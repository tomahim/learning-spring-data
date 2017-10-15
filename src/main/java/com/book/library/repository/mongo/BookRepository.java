package com.book.library.repository.mongo;

import com.book.library.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRespository extends MongoRepository<Book, String>, BookRepositoryCustomAbc {

    public List<Book> findByAuthor(String authorName);

}
