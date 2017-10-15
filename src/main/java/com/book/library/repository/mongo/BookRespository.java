package com.book.library.repository.mongo;

import com.book.library.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRespository extends MongoRepository<Book, String> {

    public Book findByAuthor(String authorName);

}
