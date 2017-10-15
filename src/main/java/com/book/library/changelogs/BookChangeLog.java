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
import java.io.InputStream;
import java.util.List;

@ChangeLog
@Component
public class BookChangeLog {

    final boolean runAlways = true;

    @ChangeSet(order="001", id="reinitBookCollection", author = "testAuthor", runAlways = runAlways)
    public void reinitBookCollection(MongoTemplate mongoTemplate) {
        mongoTemplate.dropCollection("books");
        mongoTemplate.createCollection("books");
        ObjectMapper mapper = new ObjectMapper();

        try {
            List<Book> books = mapper.readValue(getFile("books.json"), new TypeReference<List<Book>>() {});
            mongoTemplate.insertAll(books);
            Book book = new Book("Toto");
            book.setYear(1880);
            mongoTemplate.save(book);
        } catch (Exception e) {

        }
    }

    private File getFile(String fileName) {
        return new File("/C:/Users/Thomas/dev/library/src/main/resources/books.json");
    }

}

