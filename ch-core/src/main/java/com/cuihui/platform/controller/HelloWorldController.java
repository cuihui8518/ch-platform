package com.cuihui.platform.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldController.class);

    @RequestMapping("/hello")
    public String hello() {
        LOGGER.info("call method hello");
        return "Hello World!";
    }
}
