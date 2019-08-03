package com._520.smis.dao.impl;

import com._520.smis.dao.IStudentDAO;
import com._520.smis.domain.Student;
import com._520.smis.util.JdbcUtil;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements IStudentDAO {
    JdbcUtil jdbcUtil = new JdbcUtil();
    @Override
    public void save(Student stu) {
        String sql = ("INSERT INTO t_student " +
                "(name,age,math,computer,english) VALUES (?,?,?,?,?)");
        jdbcUtil.upDate(sql,stu.getName(),stu.getAge(),
                stu.getMath(),stu.getComputer(),stu.getEnglish());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM t_student WHERE id = ?";
        jdbcUtil.upDate(sql,id);
    }

    @Override
    public void update(Long id, Student stu) {
        String sql = "UPDATE t_student SET name = ? , math = ? WHERE id = ?";
        jdbcUtil.upDate(sql,stu.getName(),stu.getAge(),id);
    }

    @Override
    public List<Student> get(Long id) {
        String sql = "SELECT * FROM t_student WHERE id = ?" ;
        return jdbcUtil.query(sql,id);
    }

    @Override
    public List<Student> getAll() {
        String sql = "SELECT * FROM t_student";
        return jdbcUtil.query(sql);
    }
}
