package com.dewiz.springdatajpatest.repository;

import com.dewiz.springdatajpatest.entity.Guardian;
import com.dewiz.springdatajpatest.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    void saveStudent() {
        Student student = Student.builder()
                .emailId("ivanov1@gmail.com")
                .firstName("Ivan")
                .lastName("Ivanov")
//                .guardianName("Petr")
//                .guardianEmail("Petrov")
//                .guardianMobile("9999999999")
                .build();
        studentRepository.save(student);
    }

    @Test
    void saveStudentWithGuardian() {
        Student student = Student.builder()
                .emailId("olegov@gmail.com")
                .firstName("Oleg")
                .lastName("Olegov")
                .guardian(
                        new Guardian(
                                "Fin",
                                "Finov",
                                "9999999999")
                )
                .build();
        studentRepository.save(student);
    }

    @Test
    void printAllStudents() {
        List<Student> students = studentRepository.findAll();
        System.out.println(students);
    }
}
