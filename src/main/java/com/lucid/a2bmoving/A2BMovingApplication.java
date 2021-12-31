package com.lucid.a2bmoving;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class A2BMovingApplication {

    private static final Logger logger = LoggerFactory.getLogger(A2BMovingApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(A2BMovingApplication.class, args);
        logger.info("Hello Spring Boot");
    }
}
