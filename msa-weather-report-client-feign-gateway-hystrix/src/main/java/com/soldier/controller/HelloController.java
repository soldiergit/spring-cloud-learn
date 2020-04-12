package com.soldier.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author soldier
 * @Date 20-3-25 上午8:41
 * @Email:583406411@qq.com
 * @Version 1.0
 * @Description:
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello world!";
    }
}
