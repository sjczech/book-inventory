package com.sheila.book;

import com.sheila.book.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * BookRespository is used to save entries that are created, updated, and deleted by the user
 */

public interface BookRepository extends CrudRepository<Book, Long> {

}
