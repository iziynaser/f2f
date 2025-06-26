package com.f2f.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SampleTask implements ScheduledTask {

    private static final Logger logger = LoggerFactory.getLogger(SampleTask.class);

    /**
     * اجرای تسک هر روز ساعت 2:30 صبح
     */
    @Override
    @Scheduled(cron = "0 30 2 * * *")
    public void execute() {
        try {
            logger.info("SampleTask started at {}", LocalDateTime.now());
            // منطق تسک اینجا قرار می‌گیرد
            System.out.println("[ task start time :  " + LocalDateTime.now() + " ]");
            logger.info("SampleTask finished successfully");
        } catch (Exception e) {
            logger.error("Error occurred in SampleTask", e);
            // اگر بخواهی می‌توانی ایمیل خطا بفرستی یا هشدار بدهی
        }
    }
}
