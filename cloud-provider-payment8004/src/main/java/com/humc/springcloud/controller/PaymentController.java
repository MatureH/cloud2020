package com.humc.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @GetMapping("/helloworld")
    public String HelloWorld() {
        return "Hello World!";
    }
}
