package com.example.books.controllers;

import com.example.books.entitys.Book;
import com.example.books.service.BookServicePostgreImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditBookController {

    private BookServicePostgreImpl postgre;

    @Autowired
    public void setPostgre(BookServicePostgreImpl postgre)
    {
        this.postgre = postgre;
    }

    @GetMapping("/BooksList/{id}")
    public String editBookPage(@PathVariable("id") Integer id, Model model)
    {
        Book book = postgre.getBookById(id);
        if(book != null) {
            model.addAttribute("name", book.getName());
            model.addAttribute("year", book.getPublishYear().toString());
            model.addAttribute("comment", book.getComment());
            return "EditBook";
        }
        return "redirect:/BooksList";
    }

    @PostMapping("/BooksList/{id}/update")
    public String updateBook(
            @PathVariable("id") Integer id,
            @RequestParam(value="name") String name,
            @RequestParam(value="year") String year,
            @RequestParam(value="comment") String comment
    )
    {
        if(
                (name.equals(BookServicePostgreImpl.DEF_BOOK_PARAM)) ||
                (year.equals(BookServicePostgreImpl.DEF_BOOK_PARAM)) ||
                (comment.equals(BookServicePostgreImpl.DEF_BOOK_PARAM))
        )
        {
            System.out.println(name);
            System.out.println(year);
            System.out.println(comment);
            return "redirect:/BooksList/" + id;
        }
        Integer tmpYearInteger;
        try {
            tmpYearInteger = new Integer(year);
        }
        catch (NumberFormatException e)
        {
            System.out.println("E!");
            return "redirect:/BooksList/" + id;
        }

        postgre.updateBook(id, name, tmpYearInteger, comment);
        return "redirect:/BooksList";
    }

    @PostMapping("/BooksList/{id}/delete")
    public String deleteBook(@PathVariable("id") Integer id)
    {
        postgre.deleteBook(id);
        return "redirect:/BooksList";
    }

}
