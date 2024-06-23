package com.f2f.sso.server.controller;

import com.f2f.dbc.service.UserAccountService;
import com.f2f.domain.*;
import com.f2f.sso.server.service.LoginHistoryService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class LoginHistoryController {

    private org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    LoginHistoryService loginHistoryService;

    @Autowired
    UserAccountService userAccountService;

    @GetMapping("/f2f/loginHistory")
    @ResponseBody
    public ResponseResult<Object> getLoginHistoryForUser(Principal principal) {
        ResponseResult<Object> responseResult = new ResponseResult<>();
        String username ="";
        try {
            UserAccount userAccount = userAccountService.findByUsername(principal.getName());
            username = userAccount.getUsername();
            JsonObjects<LoginHistory> loginHistories =loginHistoryService.listByUsername(username,1,4,"id","asc");
            responseResult.setData(loginHistories.getData());
        }catch (Exception e){
            responseResult.setStatus(GlobalConstant.ERROR);
            responseResult.setMessage("error,please try again");
        }
        return responseResult;
    }
}
