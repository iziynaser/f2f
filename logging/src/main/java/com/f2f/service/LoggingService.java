package com.f2f.service;

import com.f2f.model.LoggingModel;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class LoggingService {
    private static final Logger logger = Logger.getLogger(LoggingService.class.getName());

    public void log(LoggingModel model){
        logger.info("{}");
    }
}
