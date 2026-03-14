package com.example.hibernatecrud;

import com.example.hibernatecrud.dao.StudentDao;
import com.example.hibernatecrud.entity.Student;
import com.example.hibernatecrud.util.HibernateUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDao dao = new StudentDao();

        System.out.println("--- CREATE ---");
        Long id1 = dao.create(new Student("Ava Patel", "ava.patel@example.com", 20));
        Long id2 = dao.create(new Student("Noah Rivera", "noah.rivera@example.com", 22));

        System.out.println("--- READ BY ID ---");
        Student s1 = dao.findById(id1);
        System.out.println(s1);

        System.out.println("--- READ ALL ---");
        List<Student> students = dao.findAll();
        students.forEach(System.out::println);

        System.out.println("--- UPDATE ---");
        s1.setAge(21);
        s1.setName("Ava Patel-Updated");
        dao.update(s1);
        System.out.println(dao.findById(id1));

        System.out.println("--- DELETE ---");
        dao.deleteById(id2);
        System.out.println("After delete:");
        dao.findAll().forEach(System.out::println);

        HibernateUtil.shutdown();
    }
}
