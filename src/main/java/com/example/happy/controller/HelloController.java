package com.example.happy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloController {

    @GetMapping("/say")
    public String sayHello() {
        log.info("hello, this is ubuntu saying hello to you !");
        return "hello, this is ubuntu saying hello to you !";
    }
}
