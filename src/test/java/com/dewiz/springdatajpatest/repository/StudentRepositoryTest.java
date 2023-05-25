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

    @Test
    void printStudentByFirstName() {
        List<Student> student = studentRepository.findByFirstName("Ivan");
        System.out.println(student);
    }
    @Test
    void printStudentByFirstNameContaining() {
        List<Student> student = studentRepository.findByFirstNameContaining("v");
        System.out.println(student);
    }
    @Test
    void printStudentByLastNameNotNull() {
        List<Student> student = studentRepository.findByLastNameNotNull();
        System.out.println(student);
    }

    @Test
    void printStudentByGuardianName() {
        List<Student> student = studentRepository.findByGuardianName("Fin");
        System.out.println(student);
    }
    @Test
    void printStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("ivanov@gmail.com");
        System.out.println(student);
    }
    @Test
    void printStudentByFirstNameAndLastName() {
        Student student = studentRepository.findTopByFirstNameAndLastName("Ivan", "Ivanov");
        System.out.println(student);
    }
    @Test
    void printStudentFirstNameByEmailAddress() {
        String studentFirstName = studentRepository.getStudentFirstNameByEmailAddress("ivanov@gmail.com");
        System.out.println(studentFirstName);
    }
    @Test
    void printStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("ivanov@gmail.com");
        System.out.println(student);
    }
    @Test
    void printStudentByEmailAddressNativeNamedParams() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParams("ivanov@gmail.com");
        System.out.println(student);
    }

    @Test
    void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameBYEmailId(
                "Igor",
                "ivanov@gmail.com"
        );
    }
}
