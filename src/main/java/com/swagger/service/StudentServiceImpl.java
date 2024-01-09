package com.swagger.service;

import com.swagger.entity.Student;
import com.swagger.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;  //create repository object

    @Override
    public List<Student> allStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student updateStudentsById(Long id, Student updatedStudent) {
        Student updatedStudents = studentRepository.findById(id).orElse(null);
        if(updatedStudents!=null){
            return studentRepository.save(updatedStudents);
        }
        return null;
    }
}
