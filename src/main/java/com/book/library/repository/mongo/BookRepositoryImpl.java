package com.book.library.repository.mongo;

import com.book.library.domain.Book;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.beans.Transient;
import java.util.List;

public class BookRepositoryCustomImpl implements BookRepositoryCustomQueries {

    private MongoTemplate mongoTemplate;

    final String COLLECTION = "books";

    public BookRepositoryCustomImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    @Transient
    public List<Book> search(String country) {
        Query query = new Query(Criteria.where("country").is("Nigeria"));
        return mongoTemplate.find(query, Book.class, COLLECTION);
    }
}
