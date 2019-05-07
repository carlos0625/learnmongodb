package cn.edu.ncu.learn.service;

import cn.edu.ncu.learn.dao.StudentDao;
import cn.edu.ncu.learn.entity.Student;

import java.util.List;

public class StudentService {
    private StudentDao studentDao = new StudentDao();

    public void addStudents(List<Student> students) {
        studentDao.insertStudent(students);
    }

    public void createStudentCollection() {
        studentDao.createStudentCollection();
    }

    public List<Student> findAllStudents() {
        return studentDao.queryAllStudents();
    }
}
