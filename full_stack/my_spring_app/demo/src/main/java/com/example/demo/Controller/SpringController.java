package com.example.demo.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class SpringController {

    @GetMapping("/api")
    public String welcome() {
        return "Welcome to Spring Boot";
    }
}
