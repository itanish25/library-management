package com.practice.librarymanagement.service;

import com.practice.librarymanagement.entity.Book;
import com.practice.librarymanagement.entity.User;
import com.practice.librarymanagement.repository.BookRepository;
import com.practice.librarymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

//    public Optional<Book> findById(Long id) {
//        return bookRepository.findById(id);
//    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

//    public void deleteById(Long id) {
//        Book result = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
//    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public Book borrowBook(Long bookId, Long userId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        if(book != null && !book.isBorrowed() && user != null) {
            book.setBorrowedBy(user);
            book.setBorrowed(true);
            return bookRepository.save(book);
        }
        return null;
    }

    public Book returnBook(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        if(book!=null && book.isBorrowed()) {
            book.setBorrowedBy(null);
            book.setBorrowed(false);
            return bookRepository.save(book);
        }
        return null;
    }
}



























