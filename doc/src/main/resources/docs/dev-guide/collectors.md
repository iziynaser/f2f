##b1

```

کلاس Collectors = کارخانه ساختن Collectorها برای Stream.

```

## c1


```
تبدیل به لیست
List<String> names = stream.collect(Collectors.toList());

```

##  c2


```
    گروه‌بندی دانش‌آموزان بر اساس کلاس
    Map<String, List<Student>> grouped =
        students.stream()
        .collect(Collectors.groupingBy(Student::getClassName));

```


## c3


```
        3. جمع کل مقادیر عددی
        int total = list.stream().collect(Collectors.summingInt(Item::getPrice));

```



## c4


```
        تبدیل به Map
        Map<Long, String> map = users.stream()
        .collect(Collectors.toMap(User::getId, User::getName));

```


