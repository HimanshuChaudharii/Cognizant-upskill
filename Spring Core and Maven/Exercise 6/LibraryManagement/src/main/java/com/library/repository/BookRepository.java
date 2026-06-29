package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    public void showBook() {
        System.out.println("Book data fetched from repository.");
    }

}