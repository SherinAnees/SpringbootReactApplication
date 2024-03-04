package com.learning.StudentManagmentSystem.repo;

import com.learning.StudentManagmentSystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
