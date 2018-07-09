package com.example.demo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gzhou2
 * @date 2018/6/19 14:04
 */

@Controller
@RequestMapping("/hello")
public class HelloController {


    @GetMapping("/sayHello")
    public String hello() {
        return "Hello Spring boot.";
    }


}
