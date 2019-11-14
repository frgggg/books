package com.example.books.controllers;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainPageController {

    @GetMapping("/")
    public String mainPage(
            Model model
    )
    {
        return "MainPage";
    }

    @PostMapping("/seeBooksList")
    public String seeBooksList()
    {
        return "redirect:/BooksList";
    }
}
