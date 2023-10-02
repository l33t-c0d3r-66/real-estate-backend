package com.real.estate.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @RequestMapping(value = "/public/hello", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello World";
    }

    @RequestMapping(value = "/v1/bye", method = RequestMethod.GET)
    public String sayBye() {
        return "Hello World";
    }
}
