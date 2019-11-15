package com.example.books.entitys;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "books_table")
public class Book {
    @Id
    @GeneratedValue
    private Integer id;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @Column(name = "publish_year")
    private Integer publishYear;

    @Getter
    @Setter
    @Column(name = "comment")
    private String comment;

    public static final String NULL_NAME = "null_name";
    public static final Integer NULL_PUBLISH_YEAR = 0;
    public static final String NULL_COMMENT = "null_comment";

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
