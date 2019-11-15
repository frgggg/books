package com.example.books.service;

import com.example.books.entitys.Book;

import java.util.List;

public interface BookService {
    Book getBookById(Integer id);
    void saveBook(Book book);
    void updateBook(Integer id, String name, Integer publishYear, String comment);
    void deleteBook(Integer id);
    List<Book> findAll();
}
