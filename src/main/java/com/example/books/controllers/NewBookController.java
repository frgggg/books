package com.example.books.controllers;

import com.example.books.entitys.Book;
import com.example.books.service.BookServicePostgreImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NewBookController {

    private BookServicePostgreImpl postgre;

    private static final String DEF_BOOK_PARAM = "";

    private String tmpName = DEF_BOOK_PARAM;
    private String tmpYear = DEF_BOOK_PARAM;
    private String tmpComment = DEF_BOOK_PARAM;

    @Autowired
    public void setPostgre(BookServicePostgreImpl postgre)
    {
        this.postgre = postgre;
    }

    @GetMapping("/NewBook")
    public String newBookPage(
            @RequestParam(value="name", required = false) String name,
            Model model
    )
    {
        model.addAttribute("name", tmpName);
        model.addAttribute("year", tmpYear);
        model.addAttribute("comment", tmpComment);
        return "NewBook";
    }

    private void saveErrorBookParams(String name, String year, String comment)
    {
        tmpName = name;
        tmpYear = year;
        tmpComment = comment;
    }
    private void setDefBookParams()
    {
        tmpName = DEF_BOOK_PARAM;
        tmpYear = DEF_BOOK_PARAM;
        tmpComment = DEF_BOOK_PARAM;
    }
    @PostMapping("/NewBook")
    public String addNewBook(
            @RequestParam(value="name") String name,
            @RequestParam(value="year") String year,
            @RequestParam(value="comment") String comment
    ) {
        if(
                (name.equals("")) || (year == null) || (comment.equals(""))
        ) {
            saveErrorBookParams(name, year, comment);
            return "NewBook";
        }

        Integer tmpYearInteger;

        try {
            tmpYearInteger = new Integer(year);
        }
        catch (NumberFormatException e)
        {
            saveErrorBookParams(name, year, comment);
            return "NewBook";
        }

        saveErrorBookParams();
        postgre.saveBook(new Book(name, tmpYearInteger, comment));
        return "redirect:/BooksList";
    }
}
