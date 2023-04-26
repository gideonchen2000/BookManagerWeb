package com.book.bookmanagerweb.service;

import com.book.bookmanagerweb.entity.Book;
import com.book.bookmanagerweb.entity.Borrow;
import com.book.bookmanagerweb.entity.Student;

import java.util.List;
import java.util.Map;

public interface BookService {
    List<Borrow> getBorrowList();

    void returnBook(String id);

    List<Book> getActiveBookList();

    List<Student> getStudentList();

    void addBorrow(int sid, int bid);

    Map<Book, Boolean> getBookList();

    void deleteBook(int bid);

    void addBook(String title, String desc, double price);
}
