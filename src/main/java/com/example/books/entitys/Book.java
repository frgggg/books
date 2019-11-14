package com.example.books.entitys;

import javax.persistence.*;

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

    public Integer getId() {
        return id;
    }

    /*public void setId(Integer id) {
        this.id = id;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
