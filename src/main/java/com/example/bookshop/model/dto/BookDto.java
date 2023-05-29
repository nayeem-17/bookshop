package com.example.bookshop.model.dto;

import com.example.bookshop.model.entity.Book;

import lombok.Data;

@Data
public class BookDto {
    private int id;
    private String title;
    private String price;

    private int authorId;

    private String genre;
    private String publisher;
    private int year_of_publish;

    public void toDTO(Book book) {
        if (book == null)
            return;
        this.id = book.getId();
        this.title = book.getTitle();
        this.price = book.getPrice();
        if (book.getAuthor() != null)
            this.authorId = book.getAuthor().getId();

        this.genre = book.getGenre();
        this.publisher = book.getPublisher();
        this.year_of_publish = book.getYear_of_publish();
    }

    public Book toBook(BookDto bookDto) {
        if (bookDto == null)
            return null;
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setPrice(bookDto.getPrice());
        book.setGenre(bookDto.getGenre());
        book.setPublisher(bookDto.getPublisher());
        book.setYear_of_publish(bookDto.getYear_of_publish());
        return book;
    }
}
