package com.group.libraryapprimi.repository.book;

import org.springframework.stereotype.Repository;

@Repository
public class BookMySQLRepository implements BookRepository {

    @Override
    public void saveBook() {
        System.out.println("BookMySQLRepository");
    }

}
