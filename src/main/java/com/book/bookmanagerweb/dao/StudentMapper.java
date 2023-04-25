package com.book.bookmanagerweb.dao;

import com.book.bookmanagerweb.entity.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    @Select("select * from student")
    List<Student> getStudentList();
}
