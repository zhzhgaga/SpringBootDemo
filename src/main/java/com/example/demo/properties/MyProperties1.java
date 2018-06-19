package com.example.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author gzhou2
 * @date 2018/6/19 13:50
 */

@Component
@ConfigurationProperties(prefix = "my1")
public class MyProperties1 {

    private int value;
    private String name;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyProperties1{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
