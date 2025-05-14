package com.example.database_with_docker_demo.controller;

import com.example.database_with_docker_demo.entity.Student;
import com.example.database_with_docker_demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    public StudentRepository studentRepository;

    @PostMapping("/add-student")
    public String addStudent(){
        Student s = new Student();
        s.setName("Anna White");
        s.setAge(18);
        studentRepository.save(s);
        return "Student added!";
    }

    @GetMapping("/get-students")
    public List<Student> getStudents(){
        return studentRepository.findAll();
//        return List.of(
//                new Student(1, "Alice Johnson", 20),
//                new Student(2, "Bob Smith", 22),
//                new Student(3, "Charlie Davis", 19),
//                new Student(4, "Diana Evans", 21),
//                new Student(5, "Ethan Brown", 23),
//                new Student(6, "Fiona Clark", 20),
//                new Student(7, "George Harris", 24),
//                new Student(8, "Hannah Lewis", 18),
//                new Student(9, "Ian Walker", 22),
//                new Student(10, "Julia Robinson", 21)
//        );
    }
}