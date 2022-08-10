package com.ipreptech.management.controllers;

import com.ipreptech.management.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/")
@Slf4j
public class IPTHomeController {

    @GetMapping("hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        log.error("We are om hello path");
        return String.format("<h1>Hello %s!<h1>", name);
    }

    @GetMapping
    public String home() {
        return "<h1>We are on Home page. Welcome to the class!!!  </h1>";
    }
}
