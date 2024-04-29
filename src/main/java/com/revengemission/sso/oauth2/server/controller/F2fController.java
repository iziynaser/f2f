package com.revengemission.sso.oauth2.server.controller;

import com.f2f.util.UserValidationUtils;
import com.revengemission.sso.oauth2.server.domain.UserAccount;
import com.revengemission.sso.oauth2.server.service.UserAccountService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@CrossOrigin("*")
public class F2fController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @RequestMapping("/hello")
    public Map<String, Object> info() {
        Map<String, Object> result = new HashMap<>(16);

<<<<<<< Updated upstream
        log.info("/f2f/hello is called successfully!!");
        result.put("message","this is a test controller");
=======
        log.info("/hello is called successfully!!");
        result.put("message", "this is a test controller");
>>>>>>> Stashed changes
        return result;
    }
}
