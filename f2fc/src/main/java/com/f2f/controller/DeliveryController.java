package com.f2f.controller;

import com.f2f.domain.UserAccount;
import com.f2f.entity.Delivery;
import com.f2f.entity.DeliveryDTO;
import com.f2f.entity.Ostan;
import com.f2f.entity.Shahr;
import com.f2f.persistence.entity.UserAccountEntity;
import com.f2f.service.DeliveryService;
import com.f2f.service.OstanService;
import com.f2f.service.ShahrService;
import com.f2f.service.UserAccountService;
import com.github.dozermapper.core.Mapper;
import com.f2f.domain.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/f2f/Delivery")
public class DeliveryController {

    @Autowired
    UserAccountService userAccountService;

    @Autowired
    DeliveryService deliveryService;

    @Autowired
    OstanService ostanService;

    @Autowired
    ShahrService shahrService;

    @Autowired
    Mapper mapper;

    @GetMapping("/list")
    public List<Delivery> getDeliveriesForUser(Principal principal){
        UserAccount userAccount = userAccountService.findByUsername(principal.getName());
        List<Delivery> deliveryList = deliveryService.findAllByUserAccount(userAccount);
        return deliveryList;
    }

    @GetMapping("/defaultDelivery")
    public Delivery getDefaultDelivery(Principal principal){

        UserAccount userAccount = userAccountService.findByUsername(principal.getName());
        Delivery delivery = deliveryService.findFirstDeliveryByUserAccount(userAccount);
        return delivery;

    }

    @ResponseBody
    @DeleteMapping("/delete")
    public String deleteDeliveryAddress(Principal principal,@RequestBody DeliveryDTO deliveryDto){
        UserAccount userAccount = userAccountService.findByUsername(principal.getName());
        UserAccountEntity userAccountEntity = mapper.map(userAccount,UserAccountEntity.class);

        Delivery delivery = deliveryService.findFirstById(deliveryDto.getId());
        if(!delivery.getUserAccountEntity().getUsername().equals(userAccount.getUsername()))
            throw new SecurityException("you not allowed delete this delivery service");

        deliveryService.deleteDeliveryById(deliveryDto.getId());
        return deliveryDto.getId().toString();
    }

    @ResponseBody
    @PostMapping("/save")
    public DeliveryDTO createDeliveryAddress(Principal principal,@RequestBody DeliveryDTO deliveryDto){

        UserAccount userAccount = userAccountService.findByUsername(principal.getName());
        UserAccountEntity userAccountEntity = mapper.map(userAccount, UserAccountEntity.class);

        Ostan ostan = ostanService.getOne(deliveryDto.getOstanId());
        if(ostan==null)
            throw new EntityNotFoundException("selected Ostan is not valid");

        Shahr shahr = shahrService.getOne(deliveryDto.getShahrId());
        if(shahr==null)
            throw new EntityNotFoundException("selected shahr is not valid");

        Delivery delivery = new Delivery();
        delivery.setOstan(ostan);
        delivery.setShahr(shahr);
        delivery.setDeliverFamily(deliveryDto.getDeliverFamily());
        delivery.setDeliverName(deliveryDto.getDeliverName());
        delivery.setMobileNo1(deliveryDto.getMobileNo1());
        delivery.setMobileNo2(deliveryDto.getMobileNo2());
        delivery.setNationalCode(deliveryDto.getNationalCode());
        delivery.setPostalAdress(deliveryDto.getPostalAdress());
        delivery.setPelak(deliveryDto.getPelak());
        delivery.setPostalCode(deliveryDto.getPostalCode());
        delivery.setUnit(deliveryDto.getUnit());
        delivery.setWhoisGetter(deliveryDto.getWhoisGetter());
        delivery.setUserAccountEntity(userAccountEntity);

        deliveryService.save(delivery);

        return deliveryDto;
    }
}