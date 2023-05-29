package com.example.bookshop.model.dto;

import java.util.List;

import com.example.bookshop.model.entity.Book;
import com.example.bookshop.model.entity.BookShop;

import lombok.Data;

@Data
public class BookShopDto {

    private int shopNumber;;
    private String shopName;
    private String location;
    private List<Book> books;
    private String contactNo;
    private String email;

    public void toDTO(BookShop bookShop) {
        if (bookShop == null)
            return;
        this.shopNumber = bookShop.getShopNumber();
        this.shopName = bookShop.getShopName();
        this.location = bookShop.getLocation();
        this.books = bookShop.getBooks();
        this.contactNo = bookShop.getContactNo();
        this.email = bookShop.getEmail();
    }

    public BookShop toBookShop(BookShopDto bookShopDto) {
        if (bookShopDto == null)
            return null;
        BookShop bookShop = new BookShop();
        bookShop.setShopName(bookShopDto.getShopName());
        bookShop.setShopNumber(bookShopDto.getShopNumber());
        bookShop.setLocation(bookShopDto.getLocation());
        bookShop.setContactNo(bookShopDto.getContactNo());
        bookShop.setEmail(bookShopDto.getEmail());
        return bookShop;
    }

}