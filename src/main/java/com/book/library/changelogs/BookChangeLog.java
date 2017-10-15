package com.book.library.changelogs;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.book.library.domain.Book;

@ChangeLog
@Component
public class BookChangeLog {

    @ChangeSet(order="001", id="test", author = "testAuthor")
    public void someChange(MongoTemplate mongoTemplate) {
        mongoTemplate.save(new Book("Toto"));
    }

}

