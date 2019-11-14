package com.example.books.entitys;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "books_table", schema = "books_schema", catalog = "")
public class Book {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "publish_year")
    private Integer publishYear;
    @Column(name = "comment")
    private String comment;

    public final String NULL_NAME = "null_name";
    public final Integer NULL_PUBLISH_YEAR = 0;
    public final String NULL_COMMENT = "null_comment";

    public Book()
    {
        name = NULL_NAME;
        publishYear = NULL_PUBLISH_YEAR;
        comment = NULL_COMMENT;
    }

    public Book(String name, Integer publishYear, String comment)
    {
        this.name = name;
        this.publishYear = publishYear;
        this.comment = comment;
    }
}
