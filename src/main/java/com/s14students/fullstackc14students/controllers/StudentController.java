package com.s14students.fullstackc14students.controllers;

import com.s14students.fullstackc14students.models.Student;
import com.s14students.fullstackc14students.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public ResponseEntity<Void> addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }


    @GetMapping("/students")
    public ResponseEntity<?> getAllStudents(){
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    // Endpoint needed to edit a category
    @PutMapping("/students/{id}")
    public ResponseEntity<Void> updateStudent(@PathVariable Long id, @RequestBody Student student){
        studentService.updateStudent(id, student);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    //Endpoint needed to Delete a category
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Endpoint needed to get a single category by id
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }
}
