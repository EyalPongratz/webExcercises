package com.example.webDemo1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @GetMapping
    public String sayHi() {
        return "Hello users";
    }

    @GetMapping("bye")
    public String sayBye() {
        return "Bye";
    }

    @PostMapping("bye")
    public String byeBye() {
        return "Bye bye";
    }

}
