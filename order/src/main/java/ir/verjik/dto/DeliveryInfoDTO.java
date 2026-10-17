package ir.verjik.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeliveryInfoDTO {

    private Long addressId;       // آدرس انتخاب‌شده کاربر
    private String deliveryDay;   // مثلا 'شنبه'
    private String deliveryTime;  // مثلا '10:00 - 12:00'
}
