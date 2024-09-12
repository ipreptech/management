package com.ipreptech.management;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
@Slf4j
public class ManagementApplication {

    public static void main(String[] args) {
        log.error("Hello we just started the server");
        ApplicationContext ctx = SpringApplication.run(ManagementApplication.class, args);
    }
}
