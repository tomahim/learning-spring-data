package com.book.library.repository.mongo;

import com.book.library.domain.Book;

import java.beans.Transient;
import java.util.List;

public interface BookRepositoryCustomAbc {
    List<Book> search(String country);
}
