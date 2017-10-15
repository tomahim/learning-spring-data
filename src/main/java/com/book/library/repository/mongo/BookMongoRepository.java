package com.book.library.repository.mongo;

import com.book.library.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookMongoRepository extends MongoRepository<Book, String>, BookMongoRepositoryCustom {

    List<Book> findByAuthor(String authorName);

    List<Book> findByEditionsCreatorName(String creatorEditionName);

}
