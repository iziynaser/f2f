package com.f2f.entity.other;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryDTO {

    private Long id;

    private Long userAccountId;  // فقط ID

    private Long ostanId;
    private Long shahrId;

    private String ostanName;   // فقط در خروجی (اختیاری)
    private String shahrName;   // فقط در خروجی (اختیاری)

    private String postalAddress;
    private String pelak;
    private String unit;
    private String postalCode;

    private String deliverName;
    private String deliverFamily;
    private String nationalCode;

    private String mobileNo1;
    private String mobileNo2;
    private String whoisGetter;

    private String latitude;
    private String longitude;

    private String deliveryStatus;  // Enum به صورت String

    private String deliveryDate;    // ISO format string
    private String deliveryTime;    // ISO format string

    private boolean isActive;
    private boolean isDefault;
}

