package com.adolph.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee/basic")
public class TestConmtroller {


    @RequestMapping("/test")
    public String maxWorkID() {
        System.out.println("========测试");
        return "dddd";
    }
}
