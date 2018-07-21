package com.sheila.book.service;

import com.sheila.book.model.Book;

public interface BookService {

    Iterable<Book> findAllBooks();
    Book getBookById(Long id);
    Book saveBook(Book book);
    void deleteBook(Long id);
}
