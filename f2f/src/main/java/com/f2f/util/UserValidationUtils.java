package com.f2f.util;

public class UserValidationUtils {}

//@Configuration
//public class UserValidationUtils {
//
//    private Logger log = LoggerFactory.getLogger(this.getClass());
//
//    private static final Pattern AUTHORIZATION_PATTERN = Pattern.compile("^Bearer (?<token>[a-zA-Z0-9-._~+/]+)=*$");
//
//    @Autowired
//    UserAccountService userAccountService;
//
//    @Autowired
//    TokenStore tokenStore;
//
//
//    public boolean hasAuthority(String username,String authorityName,String headerToken){
//        Map<String, Object> result = new HashMap<>(16);
//        try {
//            String token = null;
//            if (StringUtils.isNoneBlank(headerToken)) {
//                Matcher matcher = AUTHORIZATION_PATTERN.matcher(headerToken);
//                if (matcher.matches()) {
//                    token = matcher.group("token");
//                }
//            }
//
//            if (token != null) {
//                OAuth2AccessToken auth2AccessToken = tokenStore.readAccessToken(token);
//                if (auth2AccessToken.isExpired()) {
//                    return false;
//                }
//
//                UserAccount userAccount = userAccountService.findByUsername(username);
//                result.put("username", username);
//                ArrayList<String> authorityNames = (ArrayList<String>) auth2AccessToken.getAdditionalInformation().get("authorities");
//                if(authorityNames.contains(authorityName))
//                    return true;
//            } else {
//                return false;
//            }
//        } catch (Exception e) {
//            if (log.isInfoEnabled()) {
//                log.info("/user/me exception", e);
//            }
//            return false;
//        }
//        return false;
//    }
//
//    public Map<String, Object> isValidUser(String headerToken){
//        Map<String, Object> result = new HashMap<>(16);
//        try{
//            String token = null;
//            if (StringUtils.isNoneBlank(headerToken)) {
//                Matcher matcher = AUTHORIZATION_PATTERN.matcher(headerToken);
//                if (matcher.matches()) {
//                    token = matcher.group("token");
//                }
//            }
//
//            if (token != null) {
//                OAuth2AccessToken auth2AccessToken = tokenStore.readAccessToken(token);
//                if (auth2AccessToken.isExpired()) {
//                    result.put("status", "false");
//                    result.put("message", "access_token is expired");
//                    return result;
//                }
//                String uname = auth2AccessToken.getAdditionalInformation().get("sub").toString();
//                UserAccount userAccount = userAccountService.findByUsername(uname);
//                result.put("username", userAccount.getUsername());
//                result.put("status", true);
//            } else {
//                result.put("status", 0);
//                result.put("message", "access_token is null");
//            }
//        }catch (Exception e){
//            if (log.isInfoEnabled()) {
//                log.info("isValidUser", e);
//            }
//            result.put("status", false);
//            result.put("message", "user is not a Valid User ");
//        }
//        return result;
//    }
//}
