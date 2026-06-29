package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository repository;

    // Constructor Injection
    public BookService(BookRepository repository) {
        this.repository = repository;
        System.out.println("BookService initialized via Constructor Injection.");
    }

    // Setter Injection
    public void setRepository(BookRepository repository) {
        this.repository = repository;
        System.out.println("BookRepository injected via Setter Injection.");
    }

    public void displayBook() {
        System.out.println("Book Service Running...");
        repository.showBook();
    }

}