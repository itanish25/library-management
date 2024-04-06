package com.practice.librarymanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private boolean borrowed;

    @ManyToOne    // This means a single book is taken by only one User but one User can take multiple books.
    @JoinColumn(name = "user_id")
    private User borrowedBy;

    // We added a relationship between the Book and User entities to track which user has borrowed a book.
}
