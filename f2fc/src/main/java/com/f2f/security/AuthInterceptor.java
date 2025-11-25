package com.f2f.security;


public class AuthInterceptor{}

//
//@Component
//public class AuthInterceptor implements HandlerInterceptor {
//
//    private final TokenValidationService tokenValidationService;
//
//    public AuthInterceptor(TokenValidationService tokenValidationService) {
//        this.tokenValidationService = tokenValidationService;
//    }
//
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//            throws Exception {
//
//        String authHeader = request.getHeader("Authorization");
//        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing Authorization header");
//            return false;
//        }
//
//        String token = authHeader.substring(7);
//        TokenValidationResponse result = tokenValidationService.validateToken(token);
//
//        if (!result.isValid()) {
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token: " + result.getError());
//            return false;
//        }
//
//        // می‌توانید username را به context اضافه کنید:
//        request.setAttribute("username", result.getUsername());
//        return true;
//    }
//}
