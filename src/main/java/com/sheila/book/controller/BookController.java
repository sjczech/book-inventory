package com.sheila.book.controller;

import com.sheila.book.service.BookService;
import com.sheila.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import javax.validation.Valid;



@Controller
public class BookController extends WebMvcConfigurerAdapter{

    //setup validation in controller
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/book").setViewName("book");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/static/**")
                .addResourceLocations(
                        "classpath:/static/"
                );
    }

    //injecting BookService
    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * route to create a new book
     * @param model mapped to single book
     * @return the bookform html
     */
    @RequestMapping("/book/new")
    public String newBook(Model model){
        model.addAttribute("book", new Book ());
        return "bookform";
    }

    /**
     * map Post request and /book url to controller method
     * @param book object
     * @param bindingResult checks the fields for validation
     * @return the  html if there are errors
     * or else return the book detail page
     */
    @PostMapping("/book")
    public String saveBook(@Valid Book book, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "bookform";
        }
        bookService.saveBook(book);
        return "redirect:/book/" + book.getId();
    }

    /**
     * route to get a single book page
     * @param id  grab the book id
     * @param model mapped to single book
     * @return single book page
     */
    @RequestMapping("/book/{id}")
    public String showEmployee(@PathVariable Long id, Model model){
        model.addAttribute("book", bookService.getBookById(id));
        return "bookshow";
    }

    /**
     * map Get request and /books url to controller method
     * @param model mapped to all books
     * @return list of books in books.html
     */
    @GetMapping("/books")
    public String list(Model model){
        model.addAttribute("book", bookService.findAllBooks());
        return "books";
    }

    /**
     * Route to edit an book
     * @param id grab the book id
     * @param model mapped to a single book
     * @return bookform.html page
     */
    @RequestMapping("/book/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("book", bookService.getBookById(id));
        return "bookform";
    }

    /**
     * Route to delete a book
     * @param id grab the book id
     * @return redirect to list of books after deletion
     */
    @RequestMapping("/book/delete/{id}")
    public String delete(@PathVariable Long id){
        bookService.deleteBook(id);
        return "redirect:/books";
    }

}
