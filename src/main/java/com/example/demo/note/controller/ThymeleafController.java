package com.example.demo.note.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {
    @GetMapping("/thymeleaf-test")
    public String testPage(Model model) {
        return "test";
    }
}
