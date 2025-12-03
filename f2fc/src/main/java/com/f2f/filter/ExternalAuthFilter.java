package com.f2f.filter;

import com.f2f.dto.TokenValidationResponse;
import com.f2f.service.AuthClient;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class ExternalAuthFilter extends OncePerRequestFilter {

    @Autowired
    private AuthClient authClient;

    // مسیرهایی که نیازمند احراز هویت هستند
    private static final List<String> PROTECTED_PATHS = List.of(
//            "/api/store/profile",
//            "/api/store/cart",
//            "/api/store/checkout",
//            "/api/store/order"
    );

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String path = request.getRequestURI();

        // مسیرهای عمومی → بدون چک توکن رد شوند
        if (isPublicPath(path)) {
            filterChain.doFilter(request, response);
            return;
        }

        // مسیرهای حساس → نیازمند توکن
        String token = extractToken(request);
        if (token == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Missing Authorization token");
            return;
        }

        TokenValidationResponse validation = authClient.validateToken(token);
        if (validation == null || !validation.isValid()) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Invalid token");
            return;
        }

        // تنظیم SecurityContext
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                        validation.getUsername(),
                        null,
                        validation.getRoles().stream()
                                .map(SimpleGrantedAuthority::new)
                                .toList()
                );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }

    private boolean isPublicPath(String path) {
        // مسیرهای عمومی فروشگاه
        if (path.startsWith("/api/store/img") || path.startsWith("/api/store/images") || path.startsWith("/api/store/public") || path.equals("/api/store") || path.startsWith("/api/store/")) {
            // فقط مسیرهای PROTECTED_PATHS نیازمند توکن هستند
            return PROTECTED_PATHS.stream().noneMatch(path::startsWith);
        }
        // سایر مسیرها غیر عمومی → نیازمند توکن
        return false;
    }

    private String extractToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        return (header != null && header.startsWith("Bearer ")) ? header.substring(7) : null;
    }
}
