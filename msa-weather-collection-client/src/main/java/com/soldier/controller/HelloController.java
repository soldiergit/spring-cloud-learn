package com.soldier.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author soldier
 * @Date 20-3-24 上午9:40
 * @Email:583406411@qq.com
 * @Version 1.0
 * @Description:
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello world!";
    }
}
