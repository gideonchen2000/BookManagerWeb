package com.book.bookmanagerweb.service;

import com.book.bookmanagerweb.entity.Book;
import com.book.bookmanagerweb.entity.Borrow;
import com.book.bookmanagerweb.entity.Student;

import java.util.List;

public interface BookService {
    List<Borrow> getBorrowList();

    void returnBook(String id);

    List<Book> getActiveBookList();

    List<Student> getStudentList();
}
