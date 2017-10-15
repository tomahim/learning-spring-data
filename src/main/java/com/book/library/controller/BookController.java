package com.book.library.controller;

import com.book.library.domain.Book;
import com.book.library.repository.mongo.BookRespository;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookRespository bookRepository;

    public BookController(BookRespository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(method= RequestMethod.GET)
    public List<Book> index() {
        return bookRepository.findAll();
    }

}