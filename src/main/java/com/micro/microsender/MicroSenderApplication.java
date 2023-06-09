package com.micro.microsender;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.micro.microsender.controller", "com.micro.microsender.service", "com.micro.microsender.component", "com.micro.microsender.config"})
@SpringBootApplication
public class MicroSenderApplication implements ApplicationRunner {

    private static final Logger logger = LogManager.getLogger(MicroSenderApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MicroSenderApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        logger.debug("Debugging log");
//        logger.info("Info log");
//        logger.warn("Hey, This is a warning!");
//        logger.error("Oops! We have an Error. OK");
//        logger.fatal("Damn! Fatal error. Please fix me.");
    }
}
