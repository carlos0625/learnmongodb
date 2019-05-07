package cn.edu.ncu.learn;

import cn.edu.ncu.learn.entity.Student;
import cn.edu.ncu.learn.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        Random random = new Random();
        StudentService studentService = new StudentService();
        //创建学生集合
        studentService.createStudentCollection();

        /*
         * 添加学生到数据库
         */
        List<Student> students = new ArrayList<Student>();
        for (int i = 1; i <= 100; i++) {
            Student student = new Student();
            student.setId(61301100 + i);
            student.setName("学生" + i);
            student.setAge(random.nextInt(7) + 18);
            student.setGender(random.nextBoolean());
            students.add(student);
        }
        studentService.addStudents(students);

        //TODO: query all students from mongoDB
    }
}
