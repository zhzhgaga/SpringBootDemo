package com.example.demo.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gzhou2
 * @date 2018/6/19 13:55
 */
@RequestMapping("/properties")
@Controller
public class PropertiesController {

    private MyProperties1 properties;

    @Autowired
    public PropertiesController(MyProperties1 properties) {
        this.properties = properties;
    }


    @GetMapping("/properties")
    public MyProperties1 getProperties(){

        System.out.println(properties.toString());

        return properties;
    }

}
