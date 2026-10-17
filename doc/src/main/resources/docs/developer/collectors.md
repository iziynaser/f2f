کلاس Collectors = کارخانه ساختن Collectorها برای Stream.
//////////////
تبدیل به لیست
List<String> names = stream.collect(Collectors.toList());
///////////////////
    گروه‌بندی دانش‌آموزان بر اساس کلاس
    Map<String, List<Student>> grouped =
        students.stream()
        .collect(Collectors.groupingBy(Student::getClassName));
/////////////////////
        3. جمع کل مقادیر عددی
        int total = list.stream().collect(Collectors.summingInt(Item::getPrice));
////////////////////////////
        تبدیل به Map
        Map<Long, String> map = users.stream()
        .collect(Collectors.toMap(User::getId, User::getName));

