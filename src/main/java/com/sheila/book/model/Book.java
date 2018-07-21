package com.sheila.book.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * The Book class defines the structure of the data for each book entry.  This class
 * also provides validation to ensure that the user enters each field before submitting the form.
 */

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version private Integer version;

    @Size(min=1, message="You must enter an author name of at least 1 character")
    @Valid
    private String bookTitle;

    @Size(min=1, message="You must enter a book title of at least 1 character")
    @Valid
    private String bookAuthor;

    @Valid
    @Size(min=1, message="You must enter a genre of at least 1 character")
    private String  bookGenre;

    public Book(){}

    public Book(String bookTitle, String bookAuthor,  String bookGenre){
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookGenre = bookGenre;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Integer getVersion() {

        return version;
    }

    public void setVersion(Integer version) {

        this.version = version;
    }

    public String getBookTitle() {

        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {

        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {

        return bookAuthor;
    }


    public void setBookAuthor(String bookAuthor) {

        this.bookAuthor = bookAuthor;
    }

    public String getBookGenre() {

        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {

        this.bookGenre = bookGenre;
    }


    @Override
    public String toString () {
        return "Book{" +
                "id=" + id +
                ", version=" + version +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookGenre='" + bookGenre + '\'' +
                '}';
    }
}



