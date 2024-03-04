package com.learning.StudentManagmentSystem.service;

import com.learning.StudentManagmentSystem.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    public List<Student> getAllStudents();
    public String saveStudent(Student student);
    public Student getStudentById(Long id);
    public Student updateStudent(Student student);
    public void deleteStudentById(Long id);
}
