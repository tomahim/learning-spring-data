package com.book.library.controller;

import com.book.library.domain.Book;
import com.book.library.repository.mongo.BookMongoRepository;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookMongoRepository bookRepository;

    public BookController(BookMongoRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(method= RequestMethod.GET)
    public List<Book> index(@RequestParam(required = false) String authorName) {
        if (authorName != null && !authorName.isEmpty()) {
            return bookRepository.findByAuthor(authorName);
        } else {
            return bookRepository.findAll();
        }
    }

    @RequestMapping(value= "/search", method = RequestMethod.GET)
    public List<Book> search() {
        return bookRepository.search("Nigeria");
    }

}