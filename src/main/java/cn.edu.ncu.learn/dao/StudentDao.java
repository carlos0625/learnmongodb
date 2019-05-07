package cn.edu.ncu.learn.dao;

import cn.edu.ncu.learn.entity.Student;
import cn.edu.ncu.learn.util.MongoJDBC;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    /**
     * 插入一组学生
     * @param students 学生列表
     */
    public void insertStudent(List<Student> students) {
        MongoDatabase database = MongoJDBC.getDatabase();
        try {
            MongoCollection<Document> collection = database.getCollection("student");
            System.out.println("Collection student selected successfully");
            List<Document> documents = new ArrayList<Document>();
            for (Student student : students) {
                Document document = new Document("_id", student.getId())
                        .append("name", student.getName())
                        .append("age", student.getAge())
                        .append("gender", student.isGender());
                documents.add(document);
            }
            collection.insertMany(documents);
            System.out.println("document insert successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建学生集合
     */
    public void createStudentCollection() {
        MongoDatabase database = MongoJDBC.getDatabase();
        try {
            database.createCollection("student");
            System.out.println("create student collection successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有学生
     * @return students
     */
    public List<Student> queryAllStudents() {
        MongoDatabase database = MongoJDBC.getDatabase();
        List<Student> students = new ArrayList<Student>();
        try {
            MongoCollection<Document> collection = database.getCollection("student");
            System.out.println("select collection student successfully");
            FindIterable<Document> findIterable = collection.find();
            for (Document document : findIterable) {
                Student student = new Student();
                student.setId(document.getInteger("id"));
                student.setAge(document.getInteger("age"));
                student.setName(document.getString("name"));
                student.setGender(document.getBoolean("gender"));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}
