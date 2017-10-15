package com.book.library.repository.mongo;

import com.book.library.domain.Book;
import com.book.library.domain.Edition;
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
            // exact search
            query.addCriteria(Criteria.where("country").is(request.getCountryName()));
        }

        if (request.getAuthorName() != null) {
            // "LIKE" search
            query.addCriteria(Criteria.where("author").regex(request.getAuthorName()));
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

        if (request.getEditionName() != null) {
            query.addCriteria(Criteria.where("editions.name").in(request.getEditionName()));
        }

        if (request.getEditionCreatorName() != null) {
            query.addCriteria(Criteria.where("editions.creator.name").in(request.getEditionCreatorName()));
        }

        return mongoTemplate.find(query, Book.class, COLLECTION);
    }
}
