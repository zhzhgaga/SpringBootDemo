package com.example.demo.rabbitMQ.model;

import java.io.Serializable;

/**
 * @author gzhou2
 * @date 2018/7/9 15:01
 */

public class Book implements Serializable {

    private static final long serialVersionUID = -2164058270260403154L;
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
