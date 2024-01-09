package com.swagger.service;

import com.swagger.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {

    List<Student> allStudents();  //get all students details

    Student addStudent(Student student);  // save student details

    Student getStudentById(Long id);  // get student details by id

    Student updateStudentsById(Long id, Student updatedStudent);  // update student by id
}
