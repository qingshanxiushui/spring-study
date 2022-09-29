package com.bjpowernode.service.impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;

/**
 *
 */
public class StudentServiceImpl implements StudentService {

    private StudentDao dao;

    public void setDao(StudentDao dao) {
        this.dao = dao;
    }

    @Override
    public int addStudent(Student student) {
        int rows = dao.insertStudent(student);

        return rows;
    }

    @Override
    public Student findStudentById(Integer id) {

        Student student = dao.selectById(id);
        return student;
    }
}
