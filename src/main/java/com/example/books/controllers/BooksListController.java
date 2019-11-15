package com.example.books.controllers;

import com.example.books.service.BookServicePostgreImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BooksListController {

    private BookServicePostgreImpl postgre;

    @Autowired
    public void setPostgre(BookServicePostgreImpl postgre)
    {
        this.postgre = postgre;
    }

    @GetMapping("/BooksList")
    public String booksListPage(
            Model model
    )
    {
        model.addAttribute("books", postgre.findAll());
        return "BooksList";
    }
}
