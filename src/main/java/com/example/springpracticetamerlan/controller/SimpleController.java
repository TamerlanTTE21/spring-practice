package com.example.springpracticetamerlan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
//    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @GetMapping("/home")
    public String homePage() {
        return "Домашняя страница";
    }
}
