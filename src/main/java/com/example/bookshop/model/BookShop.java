package com.example.bookshop.model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class BookShop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int shopNumber;;
    private String shopName;
    private String location;
    @OneToMany(targetEntity = Book.class)
    private List<Book> books;
    // = new ArrayList<>();
    private String contactNo;
    private String email;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
}
