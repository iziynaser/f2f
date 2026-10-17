package ir.verjik.controller.sso;

import org.springframework.stereotype.Controller;

@Controller
public class LoginHistoryController {}
//
//@Controller
//public class LoginHistoryController {
//
//    private org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    LoginHistoryService loginHistoryService;
//
//    @Autowired
//    UserAccountDbcService userAccountService;
//
//    @GetMapping("/f2f/loginHistory")
//    @ResponseBody
//    public ResponseResult<Object> getLoginHistoryForUser(Principal principal) {
//        ResponseResult<Object> responseResult = new ResponseResult<>();
//        String username ="";
//        try {
//            UserAccount userAccount = userAccountService.findByUsername(principal.getName());
//            username = userAccount.getUsername();
//            JsonObjects<LoginHistory> loginHistories =loginHistoryService.listByUsername(username,1,4,"id","asc");
//            responseResult.setData(loginHistories.getData());
//        }catch (Exception e){
//            responseResult.setStatus(GlobalConstant.ERROR);
//            responseResult.setMessage("error,please try again");
//        }
//        return responseResult;
//    }
//}
