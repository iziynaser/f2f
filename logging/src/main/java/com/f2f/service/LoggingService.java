package com.f2f.service;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class LoggingService {
    private static Logger logger = Logger.getLogger(LoggingService.class.getName());

    public void log(LogModel model){
        logger.info("{}",model);
    }
}
