package ir.verjik.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DiscountContext {

    private Long productItemId;     // برای اعمال تخفیف‌های خاص کالا
    private Long personId;          // شناسه شخص جهت تخفیف‌های شخصی‌سازی‌شده
    private int quantity;           // تعداد سفارش
    private long totalAmount;       // مجموع مبلغ (اختیاری ولی مفید برای شرایط خاص)
    private Long brandId;           // برند محصول
    private Long categoryId;        // دسته‌بندی محصول
    private String geoLocation;     // موقعیت جغرافیایی
    private LocalDate requestDate;  // تاریخ درخواست (برای ارزیابی تاریخ انقضا و تخفیف روز خاص)
}
