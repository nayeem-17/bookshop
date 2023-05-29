package com.example.bookshop.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookshop.model.dto.BookDto;
import com.example.bookshop.model.entity.Book;
import com.example.bookshop.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookDto> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return books.stream()
                .map(
                        book -> {
                            BookDto bookDto = new BookDto();
                            bookDto.toDTO(book);
                            return bookDto;
                        })
                .collect(Collectors.toList());

    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        BookDto bookDto = new BookDto();
        bookDto.toDTO(book);
        return bookDto;
    }

    @PostMapping
    public BookDto createBook(@RequestBody BookDto bookDTO) {
        Book book = bookDTO.toBook(bookDTO);
        Book newBook = bookService.createBook(book);
        BookDto bookDto = new BookDto();
        bookDto.toDTO(newBook);
        return bookDto;
    }

    @PutMapping("/{id}")
    public BookDto updateBook(@PathVariable Long id, @RequestBody BookDto bookDTO) {
        Book book = bookDTO.toBook(bookDTO);
        Book updatedBook = bookService.updateBook(id, book);
        BookDto bookDto = new BookDto();
        bookDto.toDTO(updatedBook);
        return bookDto;
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @DeleteMapping("/  ")
    public void deleteAllBooks() {
        bookService.deleteAllBooks();
    }
}
