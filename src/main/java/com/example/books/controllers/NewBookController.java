package com.example.books.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewBookController {
    @GetMapping("/NewBook")
    public String newBookPage(
            Model model
    )
    {
        return "NewBook";
    }
}
