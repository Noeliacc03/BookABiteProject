package com.example.BookABite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class controller {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("mensaje", "¡Hola, bienvenido a tu primera página con Spring Boot!");
        return "index";
    }
}
