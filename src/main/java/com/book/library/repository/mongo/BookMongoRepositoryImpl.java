package com.book.library.repository.mongo;

import com.book.library.domain.Book;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class BookMongoRepositoryImpl implements BookMongoRepositoryCustom {

    private MongoTemplate mongoTemplate;

    final String COLLECTION = "books";

    public BookMongoRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Book> search(String country) {
        Query query = new Query(Criteria.where("country").is(country));
        return mongoTemplate.find(query, Book.class, COLLECTION);
    }
}
