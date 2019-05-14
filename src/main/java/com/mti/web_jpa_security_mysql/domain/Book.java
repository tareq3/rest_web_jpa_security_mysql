package com.mti.web_jpa_security_mysql.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String bookName;

    @NotBlank
    private String authorName;

    @NotBlank
    private String isbn;

    public Book() {
    }

    public Book(Long id, @NotBlank String bookName, @NotBlank String authorName, @NotBlank String isbn) {

        super();
        this.id = id;

        this.bookName = bookName;
        this.authorName = authorName;
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
