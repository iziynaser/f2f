package ir.verjik.service;

import ir.verjik.model.LoggingModel;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class LoggingService {
    private static final Logger logger = LoggerFactory.getLogger(LoggingService.class);

    public void log(LoggingModel model){
        logger.info("{}",model);
    }
}
