package com.book.bookmanagerweb.servlet.pages;

import com.book.bookmanagerweb.entity.User;
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

@WebServlet("/students")
public class StudentServlet extends HttpServlet {

    BookService service;
    @Override
    public void init() throws ServletException {
        service = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        resp.setCharacterEncoding("UTF-8");
        User user = (User) req.getSession().getAttribute("user");
        context.setVariable("nickname", user.getNickname());
        context.setVariable("student_list", service.getStudentList());
        ThymeleafUtil.process("students.html", context, resp.getWriter());
    }
}
