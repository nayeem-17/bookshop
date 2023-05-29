package com.example.bookshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookshop.model.entity.Book;
import com.example.bookshop.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book updatedBook) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            if (updatedBook.getTitle() != null)
                book.setTitle(updatedBook.getTitle());
            if (updatedBook.getPrice() != null)
                book.setPrice(updatedBook.getPrice());
            if (updatedBook.getGenre() != null)
                book.setGenre(updatedBook.getGenre());
            if (updatedBook.getPublisher() != null)
                book.setPublisher(updatedBook.getPublisher());
            if (updatedBook.getYear_of_publish() > 0)
                book.setYear_of_publish(updatedBook.getYear_of_publish());
            if (updatedBook.getAuthor() != null)
                book.setAuthor(updatedBook.getAuthor());
            System.out.println(book);
            return bookRepository.save(book);
        }
        return null;
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public void deleteAllBooks() {
        bookRepository.deleteAll();
    }
}
