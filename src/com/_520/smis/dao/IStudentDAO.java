package com._520.smis.dao;

import com._520.smis.domain.Student;
import java.util.List;

//封装Student的增删改查操作
public interface IStudentDAO {
    /**
     * 保存
     *
     * @param stu 学生对象，封装了需要保存的信息
     */
    void save(Student stu);

    /**
     * 删除
     *
     * @param id 被删除对象的主键值
     */
    void delete(Long id);

    /**
     * 修改
     *
     * @param id     需要修改对象的主键值
     * @param newStu 新的学生信息
     */
    void update(Long id, Student newStu);

    /**
     * 查询指定id的学生信息
     *
     * @param id 被查询学生的主键值
     * @return 如果有返回学生对象，否则返回null
     */
    List<Student> get(Long id);

    /**
     * 查询所有学生信息
     *
     * @return 如果结果集不为空返回所有学生信息，否则返回空集合
     */
    List<Student> getAll();
}