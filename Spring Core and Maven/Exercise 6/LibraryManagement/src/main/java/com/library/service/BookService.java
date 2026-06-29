package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository repository;

    @Autowired
    public void setRepository(BookRepository repository) {
        this.repository = repository;
    }

    public void displayBook() {
        System.out.println("Book Service Running...");
        repository.showBook();
    }

}