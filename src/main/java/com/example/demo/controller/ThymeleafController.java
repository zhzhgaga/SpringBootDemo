package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author gzhou2
 * @date 2018/6/28 15:12
 */

@Controller
@RequestMapping
public class ThymeleafController {
//http://localhost:9090/dev/index
    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        view.addObject("title", "my first web page title.");
        view.addObject("desc", "my first wab page desc.");
        view.addObject("title", "first web page.");
        Author author = new Author(99, "zhzhgagaaaa", "zhzhgagaaaa@zhzhgaga.com");
        view.addObject("author", author);
        return view;
    }

    private class Author {
        private int age;
        private String name;
        private String email;

        public Author(int age, String name, String email) {
            this.age = age;
            this.name = name;
            this.email = email;
        }

        public Author() {
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
