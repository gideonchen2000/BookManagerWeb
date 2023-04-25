package com.book.bookmanagerweb.servlet.manage;

import com.book.bookmanagerweb.service.BookService;
import com.book.bookmanagerweb.service.impl.BookServiceImpl;
import com.book.bookmanagerweb.utils.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;

@WebServlet("/add-borrow")
public class AddBorrowServlet extends HttpServlet {

    BookService service;
    @Override
    public void init() throws ServletException {
        service = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        resp.setCharacterEncoding("UTF-8");
        context.setVariable("book_list", service.getActiveBookList());
        context.setVariable("student_list", service.getStudentList());
        ThymeleafUtil.process("add-borrow.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}