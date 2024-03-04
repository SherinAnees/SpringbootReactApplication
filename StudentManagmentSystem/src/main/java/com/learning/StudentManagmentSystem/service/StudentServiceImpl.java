package com.learning.StudentManagmentSystem.service;

import com.learning.StudentManagmentSystem.model.Student;
import com.learning.StudentManagmentSystem.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

   @Autowired
    private StudentRepository repo;
    @Override

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public String saveStudent(Student student) {
        repo.save(student);
        return "Saved Successfully";
    }

    @Override
    public Student getStudentById(Long id) {
        return repo.findById(id).orElseThrow(()->new NoSuchElementException("Student not found with id "+id));
    }

    @Override
    public Student updateStudent(Student student) {
        return repo.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        repo.deleteById(id);

    }
}
