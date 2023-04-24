package com.book.bookmanagerweb.service.impl;

import com.book.bookmanagerweb.service.UserService;
import com.book.bookmanagerweb.dao.UserMapper;
import com.book.bookmanagerweb.entity.User;
import com.book.bookmanagerweb.utils.MybatisUtil;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {

    @Override
    public boolean auth(String username, String password, HttpSession session) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUser(username, password);
            if (user == null) return false;
            session.setAttribute("user", user);
            return true;
        }
    }
}
