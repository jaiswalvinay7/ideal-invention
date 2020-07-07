package com.spnotes.kafka;


import org.apache.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HelloKafkaLogger {
    private static final Logger logger = LoggerFactory.getLogger(HelloKafkaLogger.class);

    public static void main(String[] argv) throws InterruptedException {
        System.out.println("Inside HelloKafkaLogger.main");

        while(true) {
            logger.debug("Debug message from HelloKafkaLogger.main,");
            logger.info("Info message from HelloKafkaLogger.main" );
            logger.warn("Warn message from HelloKafkaLogger.main");
            logger.error("Error message from HelloKafkaLogger.main" );
          
            Thread.sleep(3000);
        }
//        System.out.println("Exiting HelloKafkaLogger.main");
//        LogManager.shutdown();
    }
}
