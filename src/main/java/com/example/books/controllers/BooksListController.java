package com.example.books.controllers;

import com.example.books.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BooksListController {

    private BookServiceImpl bookService;

    @Autowired
    public void setBookService(BookServiceImpl bookService)
    {
        this.bookService = bookService;
    }

    @GetMapping("/BooksList")
    public String booksListPage(
            Model model
    )
    {
        model.addAttribute("books", bookService.findAll());
        return "BooksList";
    }
}
