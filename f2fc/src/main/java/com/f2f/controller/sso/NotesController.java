package com.f2f.controller.sso;

import org.springframework.stereotype.Controller;

@Controller
public class NotesController {}
//
//@Controller
//public class NotesController {
//    private Logger log = LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    NotesService notesService;
//
//    @Autowired
//    UserAccountDbcService userAccountService;
//
//    @ResponseBody
//    @RequestMapping("/f2f/notes")
//    public JsonObjects<Note> listNotes() {
//        JsonObjects<Note> result= notesService.list(1,10,"id","asc");
//        return result;
//    }
//
////    @ResponseBody
////    @PostMapping("/save")
////    public Map<String, Object> createDeliveryAddress(Principal principal,@RequestBody UserAccount ua) {
////        UserAccount userAccount = userAccountService.findByUsername(principal.getName());
////        userAccount.setEmail(ua.getEmail());
////        userAccount.setMobile(ua.getMobile());
////        userAccount.setGender(ua.getGender());
////        userAccount.setCity(ua.getCity());
////        userAccount.setAddress(ua.getAddress());
////        userAccount.setNickName(ua.getNickName());
////        userAccountService
////    }
//
//        @ResponseBody
//    @GetMapping("/f2f/userProfile")
//    public Map<String, Object> handleProfile(Principal principal,
//                                @RequestParam(value = "nickName", required = false) String nickName,
//                                @RequestParam(value = "avatarUrl", required = false) String avatarUrl,
//                                @RequestParam(value = "email", required = false) String email,
//                                @RequestParam(value = "mobile", required = false) String mobile,
//                                @RequestParam(value = "province", required = false) String province,
//                                @RequestParam(value = "city", required = false) String city,
//                                @RequestParam(value = "address", required = false) String address,
//                                @JsonFormat(pattern = "yyyy-MM-dd") @DateTimeFormat(pattern = "yyyy-MM-dd")
//                                @RequestParam(value = "birthday", required = false) LocalDate birthday,
//                                Model model) {
//        Map<String, Object> result = new HashMap<>(16);
//        try {
//            UserAccount userAccount = userAccountService.findByUsername(principal.getName());
//            result.put("nickName",userAccount.getNickName());
//            result.put("gender",userAccount.getGender());
//            result.put("username",userAccount.getUsername());
//            result.put("email",userAccount.getEmail());
//            result.put("mobile",userAccount.getMobile());
//            result.put("province",userAccount.getProvince());
//            result.put("city",userAccount.getCity());
//            result.put("address",userAccount.getCity());
//            result.put("birthday",userAccount.getBirthday().toString());
//            //result.put("roles",userAccount.getRoles());
//
//            return result;
//        } catch (EntityNotFoundException e) {
//            if (log.isErrorEnabled()) {
//                result.put("status", 0);
//                result.put("message", "access token is invalid");
//
//            }
//        }
//        return result;
//    }
//}
