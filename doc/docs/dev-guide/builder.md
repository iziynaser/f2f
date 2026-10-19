@Builder یکی از انوتیشن‌های کتابخانه Lombok است که برای ساخت الگوهای Builder Pattern به‌صورت خودکار استفاده می‌شود. این الگو در جاوا معمولاً برای ساخت اشیاء پیچیده به‌صورت مرحله‌ای و خوانا به کار می‌رود.


## b1

اما در صورت استفاده ترکیبی با JPA Entityها (یعنی در کلاس‌های @Entity) توصیه می‌شود @Builder را فقط روی DTOها یا مدل‌های ساده به کار ببرید، چون با Hibernate ممکن است تداخل داشته باشد مگر اینکه دقیقاً کنترل شده باشد.

## b2

@Getter
@Setter
@Builder
public class ContentCategoryDTO {
private Long id;
private Long contentId;
private Long categoryId;
}

## b3

کد تمیزتر و خواناتر:

مخصوصاً زمانی که کلاس شما تعداد زیادی فیلد دارد.

اجتناب از نیاز به سازنده‌های طولانی:

نیازی به constructor با چندین پارامتر نیست.

ترتیب اهمیت ندارد:

می‌توانید فیلدها را به هر ترتیبی مقداردهی کنید.

ایمنی تایپ بهتر:

به اشتباه بین پارامترهای مشابه (مثل دو Long) دچار نمی‌شوید.

## b4

return ContentCategoryDTO.builder()
.id(cc.getId())
.contentId(contentId)
.categoryId(categoryId)
.build();
