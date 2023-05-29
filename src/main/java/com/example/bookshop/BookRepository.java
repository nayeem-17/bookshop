package com.example.bookshop;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookshop.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
