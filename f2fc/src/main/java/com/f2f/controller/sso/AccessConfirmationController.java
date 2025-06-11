package com.f2f.controller.sso;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/oauth")
@SessionAttributes("authorizationRequest")
public class AccessConfirmationController {}
//
//@Controller
//@RequestMapping("/oauth")
//@SessionAttributes("authorizationRequest")
//public class AccessConfirmationController {
//
//    @Autowired
//    OauthClientService oauthClientService;
//
//    @Autowired
//    ScopeDefinitionService scopeDefinitionService;
//
//
//    @RequestMapping("/confirm_access")
//    public String getAccessConfirmation(@ModelAttribute AuthorizationRequest clientAuth,
//                                        ModelMap model,
//                                        @RequestParam(value = "redirect_uri") String redirectUri) {
//        OauthClient client = oauthClientService.findByClientId(clientAuth.getClientId());
//        model.put("auth_request", clientAuth);
//        model.put("applicationName", client.getApplicationName());
//        model.put("from", getHost(redirectUri));
//        Map<String, String> scopes = new LinkedHashMap<>();
//        for (String scope : clientAuth.getScope()) {
//            ScopeDefinition scopeDefinition = scopeDefinitionService.findByScope(scope);
//            if (scopeDefinition != null) {
//                scopes.put(OAuth2Utils.SCOPE_PREFIX + scope, scopeDefinition.getDefinition());
//            } else {
//                scopes.put(OAuth2Utils.SCOPE_PREFIX + scope, scope);
//            }
//        }
//        model.put("scopes", scopes);
//        return "accessConfirmation";
//    }
//
//    /*@RequestMapping("/confirm_access")
//    public ModelAndView getAccessConfirmation(@ModelAttribute AuthorizationRequest clientAuth) throws Exception {
//        ClientDetails client = clientDetailsService.loadClientByClientId(clientAuth.getClientId());
//        TreeMap<String, Object> model = new TreeMap<>();
//        model.put("auth_request", clientAuth);
//        model.put("client", client);
//        ModelAndView a= new ModelAndView("accessConfirmation", model);
//        return a;
//    }*/
//
//    @RequestMapping("/error")
//    public String handleError(Map<String, Object> model) {
//        // We can add more stuff to the model here for JSP rendering. If the client was a machine then
//        // the JSON will already have been rendered.
//
//        model.put("message", "There was a problem with the OAuth2 protocol");
//        return "oauthError";
//    }
//
//    private String getHost(String url) {
//        URI uri = URI.create(url);
//        if (uri.getPort() == 80 || uri.getPort() == 443 || uri.getPort() == -1) {
//            return uri.getScheme() + "://" + uri.getHost();
//        } else {
//            return uri.getScheme() + "://" + uri.getHost() + ":" + uri.getPort();
//        }
//    }
//}
