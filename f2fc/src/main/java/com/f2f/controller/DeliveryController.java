package com.f2f.controller;

import com.f2f.service.DeliveryService;
import com.f2f.service.OstanService;
import com.f2f.service.ShahrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/f2f/Delivery")
public class DeliveryController {

    private DeliveryService deliveryService;
    private OstanService ostanService;
    private ShahrService shahrService;
    //private UserAccountDbcService userAccountService;
    //private  UserAccountProvider

//    @Autowired
//    Mapper mapper;
    @Autowired
    DeliveryController(DeliveryService deliveryService,ShahrService shahrService,OstanService ostanService){
        this.deliveryService = deliveryService ;
        this.ostanService = ostanService ;
        this.shahrService = shahrService;
       // this.userAccountService = userAccountService;
    }

//    @Autowired
//    DeliveryController(DeliveryService deliveryService,UserAccountDbcService userAccountService,ShahrService shahrService,OstanService ostanService){
//        this.deliveryService = deliveryService ;
//        this.ostanService = ostanService ;
//        this.shahrService = shahrService;
//        this.userAccountService = userAccountService;
//    }

//    public UserAccountEntity copy(UserAccount ua){
//        UserAccountEntity uae = new UserAccountEntity();
//        uae.setUsername(ua.getUsername());
//        uae.setPassword(ua.getPassword());
//        uae.setAccountOpenCode(ua.getAccountOpenCode());
//        uae.setNickName(ua.getNickName());
//        uae.setAvatarUrl(ua.getAvatarUrl());
//        uae.setEmail(ua.getEmail());
//        uae.setMobile(ua.getMobile());
//        uae.setProvince(ua.getProvince());
//        uae.setCity(ua.getCity());
//        uae.setAddress(ua.getAddress());
//        uae.setBirthday(ua.getBirthday());
//        uae.setGender(ua.getGender());
//        uae.setFailureTime(ua.getFailureTime());
//        uae.setFailureCount(ua.getFailureCount());
//        uae.setRoles(copyRoles(ua.getRoles()));
//        return uae;
//    }

//    public List<RoleEntity> copyRoles(List<Role> list){
//        List<RoleEntity> roles = new ArrayList<RoleEntity>();
//        for(int i=0;i<roles.size();i++){
//            roles.add(new RoleEntity(roles.get(i).getRoleName()));
//        }
//        return roles;
//    }

//    @GetMapping("/list")
//    public List<Delivery> getDeliveriesForUser(Principal principal){
//        UserAccount userAccount = userAccountService.findByUsername(principal.getName());
//        List<Delivery> deliveryList = deliveryService.findAllByUserAccount(userAccount);
//        return deliveryList;
//    }

//    @GetMapping("/defaultDelivery")
//    public Delivery getDefaultDelivery(Principal principal){
//
//        UserAccount userAccount = userAccountService.findByUsername(principal.getName());
//        Delivery delivery = deliveryService.findFirstDeliveryByUserAccount(userAccount);
//        return delivery;
//
//    }

//    @ResponseBody
//    @DeleteMapping("/delete")
//    public String deleteDeliveryAddress(Principal principal,@RequestBody DeliveryDTO deliveryDto){
//        UserAccount userAccount = userAccountService.findByUsername(principal.getName());
//        //UserAccountEntity userAccountEntity = mapper.map(userAccount,UserAccountEntity.class);
//        UserAccountEntity userAccountEntity = copy(userAccount);
//
//        Delivery delivery = deliveryService.findFirstById(deliveryDto.getId());
//        if(!delivery.getUserAccountEntity().getUsername().equals(userAccount.getUsername()))
//            throw new SecurityException("you not allowed delete this delivery service");
//
//        deliveryService.deleteDeliveryById(deliveryDto.getId());
//        return deliveryDto.getId().toString();
//    }

//    @ResponseBody
//    @PostMapping("/save")
//    public DeliveryDTO createDeliveryAddress(Principal principal,@RequestBody DeliveryDTO deliveryDto){
//
//        UserAccount userAccount = userAccountService.findByUsername(principal.getName());
//        //UserAccountEntity userAccountEntity = mapper.map(userAccount, UserAccountEntity.class);
//        UserAccountEntity userAccountEntity = copy(userAccount);
//
//        Ostan ostan = ostanService.getOne(deliveryDto.getOstanId());
//        if(ostan==null)
//            throw new EntityNotFoundException("selected Ostan is not valid");
//
//        Shahr shahr = shahrService.getOne(deliveryDto.getShahrId());
//        if(shahr==null)
//            throw new EntityNotFoundException("selected shahr is not valid");
//
//        Delivery delivery = new Delivery();
//        delivery.setOstan(ostan);
//        delivery.setShahr(shahr);
//        delivery.setDeliverFamily(deliveryDto.getDeliverFamily());
//        delivery.setDeliverName(deliveryDto.getDeliverName());
//        delivery.setMobileNo1(deliveryDto.getMobileNo1());
//        delivery.setMobileNo2(deliveryDto.getMobileNo2());
//        delivery.setNationalCode(deliveryDto.getNationalCode());
//        delivery.setPostalAdress(deliveryDto.getPostalAdress());
//        delivery.setPelak(deliveryDto.getPelak());
//        delivery.setPostalCode(deliveryDto.getPostalCode());
//        delivery.setUnit(deliveryDto.getUnit());
//        delivery.setWhoisGetter(deliveryDto.getWhoisGetter());
//        delivery.setUserAccountEntity(userAccountEntity);
//
//        deliveryService.save(delivery);
//
//        return deliveryDto;
//    }
}