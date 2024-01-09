package com.swagger.controller;

import com.swagger.entity.Student;
import com.swagger.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController   //define its a rest api controller
@RequestMapping("/api/students")  //mapped api students table of mysql
@Tag(name = "StudentController", description = "To Perform operations...") // it provide name , description of controller layer in swagger app
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Operation(
            summary = "GET operations on students..",
            description = "It is used to retrieve students details."
    )
    @GetMapping("/all")
    public ResponseEntity<List<Student>> findAllStudents() {
        List<Student> studentList = studentService.allStudents();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @Operation(
            summary = "Post operations on students..",
            description = "It is used to save students details."
    )
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student allStudents = studentService.addStudent(student);
        return new ResponseEntity<>(allStudents, HttpStatus.CREATED);
    }
    @Operation(
            summary = "Get Student Details By Id operations on students..",
            description = "It is used to get students details by particular id."
    )
    @GetMapping("{id}")
    public ResponseEntity<Student> findStudentsById(@PathVariable Long id){
        Student getStudent = studentService.getStudentById(id);
        return new ResponseEntity<>(getStudent, HttpStatus.OK);
    }

    @Operation(
            summary = "Update Student Details By Id operations on students..",
            description = "It is used to update students details by particular id."
    )
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudentDetails(@PathVariable Long id, @RequestBody Student updatedStudent) {
        Student updated = studentService.updateStudentsById(id, updatedStudent);

        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
