package com.mti.web_jpa_security_mysql.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Book Name is required")
    private String bookName;

    @NotBlank(message = "Author name is required")
    private String authorName;

    @NotBlank(message = "ISBN is needed")
    @Size(min = 4, max = 10, message = "please use 4 to 10 chars")
    @Column(updatable = false, unique = true)
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
