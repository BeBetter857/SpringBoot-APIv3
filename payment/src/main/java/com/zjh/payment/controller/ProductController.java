package com.zjh.payment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/product")
public class ProductController {

    @RequestMapping("/test")
    public String test() {
        return "ok";
    }
}
