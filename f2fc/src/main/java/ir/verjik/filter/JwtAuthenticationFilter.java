package ir.verjik.filter;

import ir.verjik.blacklist.TokenBlacklistService;
import ir.verjik.util.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    private final JwtUtils jwtUtils;
    private final TokenBlacklistService blacklistService;

    // مسیرهای حساس که نیاز به JWT دارند
    private static final List<String> PROTECTED_PATHS = List.of(
            "/api/store/profile",
            "/api/store/cart",
            "/api/store/checkout",
            "/api/store/order"
    );

    public JwtAuthenticationFilter(JwtUtils jwtUtils, TokenBlacklistService blacklistService) {
        this.jwtUtils = jwtUtils;
        this.blacklistService = blacklistService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String path = request.getRequestURI();
        String header = request.getHeader("Authorization");

        boolean isProtected = PROTECTED_PATHS.stream().anyMatch(path::startsWith);

        logger.debug("JwtAuthenticationFilter - Request path: {}, isProtected: {}", path, isProtected);

        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            logger.debug("JwtAuthenticationFilter - JWT found: {}", token);

            if (blacklistService != null && blacklistService.isBlacklisted(token)) {
                logger.debug("JwtAuthenticationFilter - Token is blacklisted");
                if (isProtected) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }
            } else if (jwtUtils.validateJwtToken(token)) {
                String username = jwtUtils.getUserNameFromJwtToken(token);
                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
                SecurityContextHolder.getContext().setAuthentication(auth);
                logger.debug("JwtAuthenticationFilter - Token valid, authentication set for user: {}", username);
            } else if (isProtected) {
                logger.debug("JwtAuthenticationFilter - Token invalid for protected path, returning 401");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            } else {
                logger.debug("JwtAuthenticationFilter - Token invalid for public path, ignored");
            }
        } else if (isProtected) {
            logger.debug("JwtAuthenticationFilter - No token provided for protected path, returning 401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        } else {
            logger.debug("JwtAuthenticationFilter - No token, public path, proceeding anonymously");
        }

        filterChain.doFilter(request, response);
    }
}
