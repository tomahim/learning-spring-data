package com.book.library.repository.mongo;

import com.book.library.domain.Book;

import java.beans.Transient;
import java.util.List;

public interface BookMongoRepositoryCustom {
    List<Book> search(String country);
}
