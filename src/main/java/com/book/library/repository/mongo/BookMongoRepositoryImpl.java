package com.book.library.repository.mongo;

import com.book.library.domain.Book;
import com.book.library.repository.mongo.request.SearchBookRequest;
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
    public List<Book> search(SearchBookRequest request) {
        Query query = new Query();

        if (request.getCountryName() != null) {
            query.addCriteria(Criteria.where("country").is(request.getCountryName()));
        }

        if (request.getAuthorName() != null) {
            query.addCriteria(Criteria.where("author").is(request.getAuthorName()));
        }

        if (request.getPublishYearStart() != null || request.getPublishYearEnd() != null) {
            Criteria yearCriteria = new Criteria().where("year");

            if (request.getPublishYearStart() != null) {
                yearCriteria.gte(request.getPublishYearStart());
            }

            if (request.getPublishYearEnd() != null) {
                yearCriteria.lte(request.getPublishYearEnd());
            }
            query.addCriteria(yearCriteria);
        }

        return mongoTemplate.find(query, Book.class, COLLECTION);
    }
}
