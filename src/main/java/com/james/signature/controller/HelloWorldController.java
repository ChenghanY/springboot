package com.james.signature.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String sayHello() {
        return " Welcome to my home";
    }
}