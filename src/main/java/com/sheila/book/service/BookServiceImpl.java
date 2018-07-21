package com.sheila.book.service;

import com.sheila.book.BookRepository;
import com.sheila.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The BookServiceImpl class implements the methods from the BookService interface
 */

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAllBooks() {

        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {

        return bookRepository.findOne(id);
    }

    @Override
    public Book saveBook(Book book) {

        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {

        bookRepository.delete(id);
    }

}
