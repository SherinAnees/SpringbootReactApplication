package com.learning.StudentManagmentSystem.controller;

import com.learning.StudentManagmentSystem.model.Student;
import com.learning.StudentManagmentSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:5173/")
public class StudentController {

   @Autowired
    private StudentService service;


   @GetMapping("/students")
   public ResponseEntity<List<Student>> displayAllStudents(){
       List<Student> sList=service.getAllStudents();
       return new ResponseEntity<List<Student>>(sList, HttpStatus.OK);

   }
   @PostMapping("/student")
   public ResponseEntity<String>   saveStudent(@RequestBody Student student)
   {
       String st=service.saveStudent(student);
 return new ResponseEntity<String>(st,HttpStatus.OK);
   }
   @GetMapping("/student/{id}")
   public ResponseEntity<Student> getStudentDetail(Long id){
       Student st=service.getStudentById(id);
       return new ResponseEntity<Student>(st,HttpStatus.OK);
//return ResponseEntity.ok(st);
   }

   @PutMapping("/student/{id}")
   public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody Student student){

       Student st=service.getStudentById(id);
       st.setName(student.getName());
       st.setAddress(student.getAddress());
       st.setEmail(student.getEmail());
       st.setPhone(student.getPhone());
       st.setFathersName(student.getFathersName());
       st.setClassName(student.getClassName());
       Student newSt=service.updateStudent(st);
       return new ResponseEntity<Student>(newSt,HttpStatus.OK);

   }
   @DeleteMapping("/student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
    service.deleteStudentById(id);
    return ResponseEntity.noContent().build();
   }
}
