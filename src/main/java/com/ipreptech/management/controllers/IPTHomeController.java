package com.ipreptech.management.controllers;

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST;
import static javax.servlet.http.HttpServletResponse.SC_OK;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Home Controller")
@RestController(value = "/")
@Slf4j
public class IPTHomeController {

    @ApiOperation(value = "Sample Hello mapping")
    @ApiResponses(value = {@ApiResponse(code = SC_OK, message = "ok"),
        @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error")
    })
    @GetMapping("hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        log.error("We are om hello path");
        return String.format("<h1>Hello %s!<h1>", name);
    }

    @ApiOperation(value = "Sample Home mapping")
    @ApiResponses(value = {@ApiResponse(code = SC_OK, message = "ok"),
        @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error")
    })
    @GetMapping
    public String home() {
        return "<h1>We are on Home page. Welcome to the class!!!  </h1>";
    }
}
