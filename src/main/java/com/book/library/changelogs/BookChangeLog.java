package com.book.library.changelogs;

import com.book.library.domain.Book;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@ChangeLog
@Component
public class BookChangeLog {

    final boolean runAlways = true;
    final String BOOKS_COLLECTION = "books";

    @ChangeSet(order="001", id="reinitBookCollection", author = "testAuthor", runAlways = runAlways)
    public void reinitBookCollection(MongoTemplate mongoTemplate) {
        mongoTemplate.dropCollection(BOOKS_COLLECTION);
        mongoTemplate.createCollection(BOOKS_COLLECTION);
        ObjectMapper mapper = new ObjectMapper();

        try {
            List<Book> books = mapper.readValue(getFile("books.json"), new TypeReference<List<Book>>() {});
            mongoTemplate.insertAll(books);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private File getFile(String fileName) throws IOException {
        return new ClassPathResource("books.json").getFile();
    }

}

