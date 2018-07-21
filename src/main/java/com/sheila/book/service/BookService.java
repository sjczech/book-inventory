package com.sheila.book.service;

import com.sheila.book.model.Book;

/**
 * BookService is an interface that standardized methods to create, read, update,
 * and delete entries
 */

public interface BookService {

    Iterable<Book> findAllBooks();
    Book getBookById(Long id);
    Book saveBook(Book book);
    void deleteBook(Long id);
}
