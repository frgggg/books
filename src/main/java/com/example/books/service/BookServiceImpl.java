package com.example.books.service;

import com.example.books.entitys.Book;
import com.example.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookServiceImpl implements BookService {

    public static final String DEF_BOOK_PARAM = "";

    private BookRepository repository;

    @Autowired
    public void setRepository(BookRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public Book getBookById(Integer id)
    {
        return repository.findById(id).get();
    }

    @Override
    public void saveBook(Book book)
    {
        repository.save(book);
    }

    public void updateBook(Integer id, String name, Integer publishYear, String comment)
    {
        Book updated = repository.findById(id).get();
        updated.setName(name);
        updated.setPublishYear(publishYear);
        updated.setComment(comment);
        repository.save(updated);
    }

    public void deleteBook(Integer id)
    {
        repository.deleteById(id);
    }
    public List<Book> findAll()
    {
        Iterable<Book> iterator = repository.findAll();
        List<Book> ret = new ArrayList<>();
        iterator.forEach(ret::add);
        return ret;
    }
}
