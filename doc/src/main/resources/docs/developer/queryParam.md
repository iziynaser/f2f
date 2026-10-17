فرق پاس دادن پارامترها به صورت Query Params (@RequestParam) با قرار دادن اون‌ها در مسیر URL (@PathVariable) چیه و کدوم بهتره؟
///////////////////////
Query Params (@RequestParam)

ex :
GET /questions/latest?targetType=product&targetId=123&page=0&size=10

پارامترها به صورت کلید-مقدار بعد از ? می‌آیند.
مناسب وقتی که پارامترها فیلتر، مرتب‌سازی، صفحه‌بندی و تنظیمات اختیاری هستند.
تغییر دادن ترتیب پارامترها مهم نیست.
پارامترهای اختیاری یا دارای مقدار پیش‌فرض راحت‌تر هستند.
RESTful بودن کمتر تاکید دارد روی پارامترها در مسیر
///////////////////////////////////////////
Path Variables (@PathVariable)

ex :
GET /questions/latest/product/123?page=0&size=10

ex :
@GetMapping("/questions/latest/{targetType}/{targetId}")
public ResponseEntity<Page<QuestionAnswerDTO>> getLatestQuestions(
    @PathVariable String targetType,
    @PathVariable Long targetId,
    @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "10") int size) {
    // ...
    }


    پارامترها بخشی از مسیر URL هستند.
    معمولا برای شناسه‌های منبع (resource identifiers) استفاده می‌شود.
    URL خواناتر و RESTful‌تر می‌شود.
    مناسب وقتی که هدف مشخص و اصلی URL است و پارامتر بخشی از مسیر منطقی آدرس است.
    به خوانایی و ساختار URL کمک می‌کند.

//////////////////////////////



