package com.book.library.repository.mongo;

import com.book.library.domain.Book;
import com.book.library.repository.mongo.request.SearchBookRequest;
import java.util.List;

public interface BookMongoRepositoryCustom {
    List<Book> search(SearchBookRequest request);
}
