package com.book.library.controller;

import com.book.library.domain.Book;
import com.book.library.repository.mongo.BookMongoRepository;
import com.book.library.repository.mongo.request.SearchBookRequest;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value= "/search", method = RequestMethod.POST)
    public List<Book> search(@RequestBody SearchBookRequest request) {
        return bookRepository.search(request);
    }

}