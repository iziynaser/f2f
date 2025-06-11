package com.f2f.controller.sso;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/f2f/management/user")
public class ManageUserController{}
//
//@Controller
//@RequestMapping(value = "/f2f/management/user")
//public class ManageUserController {
//
//    private Logger log = LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Autowired
//    UserAccountDbcService userAccountService;
//
//    @GetMapping(value = {"/", "", "/master"})
//    public String master() {
//
//        return "user/master";
//    }
//
//    @GetMapping(value = "/list")
//    @ResponseBody
//    @PreAuthorize("hasRole('SUPER')")
//    public JsonObjects<UserAccount> listObjects(Principal principal,
//                                                @RequestParam(value = "searchValue", required = false, defaultValue = "") String searchValue,
//                                                @RequestParam(value = "draw", defaultValue = "0") int draw,
//                                                @RequestParam(value = "length", defaultValue = "10") Integer pageSize,
//                                                @RequestParam(value = "start", defaultValue = "0") Integer start,
//                                                @RequestParam(value = "sortField", required = false, defaultValue = "id") String sortField,
//                                                @RequestParam(value = "sortOrder", required = false, defaultValue = "desc") String sortOrder) {
//
//        UserAccount userAccount = userAccountService.findByUsername(principal.getName());
////        int hasRole = userAccount.getRoles().indexOf("SUPER");
////        System.out.print(hasRole);
////          if(!userAccountService.hasRole(userAccount.getRoles(),"SUPER"))
////                throw new UserRoleException(userAccount.getUsername()+"has not Role" + "SUPER");
//
//        int pageNum = start / 10 + 1;
//        JsonObjects<UserAccount> result = userAccountService.listByUsername(searchValue, pageNum, pageSize, sortField, sortOrder);
//        result.setDraw(draw + 1);
//        return result;
//    }
//
//    @GetMapping(value = "/details")
//    @ResponseBody
//    public UserAccount setupDetails(@RequestParam(value = "id") Long id,
//                                    @RequestParam(value = "additionalData", required = false) String additionalData) {
//        UserAccount object = userAccountService.retrieveById(id);
//        object.setAdditionalData(additionalData);
//        return object;
//    }
//
//    @PostMapping(value = "/details")
//    @ResponseBody
//    public ResponseResult<Object> handlePost(@RequestParam(value = "id", required = false) long id,
//                                             @RequestParam(value = "deleteOperation", required = false, defaultValue = "1") int deleteOperation,
//                                             @RequestParam(value = "nickName", required = false) String nickName,
//                                             @RequestParam(value = "address", required = false) String address,
//                                             @RequestParam(value = "password", required = false) String password) {
//
//        ResponseResult<Object> responseResult = new ResponseResult<>();
//
//
//        if (deleteOperation == -2 && id > 0) {
//            userAccountService.updateRecordStatus(id, 0);
//            responseResult.setStatus(GlobalConstant.SUCCESS);
//        } else if (deleteOperation == 0 && id > 0) {
//            userAccountService.updateRecordStatus(id, -2);
//            responseResult.setStatus(GlobalConstant.SUCCESS);
//        } else if (id > 0) {
//            UserAccount object = userAccountService.retrieveById(id);
//            if (StringUtils.isNotEmpty(password)) {
//                object.setPassword(passwordEncoder.encode(StringUtils.trim(password)));
//            }
//            if (StringUtils.isNotEmpty(address)) {
//                object.setAddress(address);
//            }
//            object.setNickName(nickName);
//            userAccountService.updateById(object);
//        } else {
//            log.info("invalid request!");
//            responseResult.setStatus(GlobalConstant.ERROR);
//        }
//
//        return responseResult;
//    }
//
//}
