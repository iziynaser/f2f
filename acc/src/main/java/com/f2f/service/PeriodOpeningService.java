package com.f2f.service;

/*
بررسی اینکه دوره قبلی Closed باشد
مقداردهی اولیه AccountBalance اگر وجود نداشت
status دوره را به OPEN تغییر بده
 */

public interface PeriodOpeningService {
    void openPeriod(Long periodId);
}
