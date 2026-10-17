package ir.verjik.dto;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * این کلاس برای نگه‌داری مقادیر موردنیاز برای بررسی شرایط اعمال تخفیف استفاده می‌شود.
 */
@Data
public class Context {

    private Long productId;
    private Long productItemId;
    private Long personId;

    private Long brandId;
    private Long categoryId;

    private String geoLocation;

    private Integer quantity;
    private Long totalAmount;

    private LocalDate requestDate;

    // فیلدهای مربوط به شرایط خاص غیرمالی 👇

    // زمان تحویل مورد نظر
    private LocalTime deliveryTime;

    // نوع کاربر (مثلاً GUEST, MEMBER, VIP ...)
    private String userType;

    // آیا این اولین سفارش کاربر است؟
    private Boolean isFirstOrder;

    // آیا سفارش از طریق اپلیکیشن است؟
    private Boolean isFromMobileApp;

    // روز هفته (در صورت نیاز برای تخفیف‌های روزانه)
    private String dayOfWeek;

    private LocalDate birthDate ;

    private String gender; // "MALE", "FEMALE"

}
