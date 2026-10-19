
## s

```
تولید داده تستی یا mock به تعداد مشخص.

سیستم‌هایی که داده‌ها رو از منابع خارجی به صورت جریان دریافت می‌کنن (مثلاً داده‌های حسگرها، لاگ‌ها، پیام‌های Kafka و...).

پیاده‌سازی الگوریتم‌های lazy evaluation (مثلاً محاسبه توالی فیبوناچی تا زمانی که نیاز داریم).

```


## examples 

```
ex1 :
Stream<Double> randomNumbers = Stream.generate(Math::random);

    List<Double> firstFive = randomNumbers
        .limit(5)
        .collect(Collectors.toList());

        System.out.println(firstFive);

## ex2

        Stream<Integer> infiniteNumbers = Stream.iterate(0, n -> n + 1);

            List<Integer> firstTen = infiniteNumbers
                .limit(10)  // فقط 10 تا اول رو بگیر
                .collect(Collectors.toList());

                System.out.println(firstTen);
## ex3

                چطوری یک Stream بی‌نهایت بسازیم؟
                جاوا با متدهای Stream.iterate() و Stream.generate() این کار رو ممکن می‌کنه
## ex4

                چرا Lazy بودن مهمه؟
                کارایی بالا: فقط تا جایی پردازش انجام می‌شه که نیاز داریم.

                پردازش زنجیره‌ای مؤثر: وقتی مثلاً ترکیب filter() و map() داریم، فقط روی موارد فیلترشده عملیات انجام می‌شه.

                امکان استفاده از infinite stream: می‌تونی استریم‌های بی‌نهایت بسازی و فقط بخشی از اون‌ها رو مصرف کنی.

## ex5 
                یعنی چی که Stream ها lazy هستند؟
                به زبان ساده:

                تا وقتی یک عملیات نهایی (مثل collect(), reduce(), forEach()) روی Stream اجرا نشه، هیچ‌کدوم از عملیات‌های وسط (مثل map(), filter()) اجرا نمی‌شن.


## ex6

                Streamها lazy هستند: یعنی تا زمانی که متد نهایی (collect, reduce, ...) صدا زده نشه، هیچ پردازشی انجام نمی‌شه!


## ex7

                List<Integer> nums = List.of(1, 2, 2, 3, 3, 3);

                    List<Integer> unique = nums.stream()
                        .distinct()
                        .collect(Collectors.toList());  // خروجی: [1, 2, 3]

## ex7

ex2: List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

                            List<Integer> even = numbers.stream()
                                .filter(n -> n % 2 == 0)
                                .collect(Collectors.toList());  // خروجی: [2, 4, 6]


```

