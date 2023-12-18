package com.s14students.fullstackc14students.services;

import com.s14students.fullstackc14students.models.Student;
import com.s14students.fullstackc14students.repos.StudentRepo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public void addStudent(Student student){
        studentRepo.save(student);
    }

    //GET ALL CATEGORIES
    public Iterable<Student>getAllStudents(){
        return studentRepo.findAll();
    }


    //DELETE A CATEGORY BY ID
    public void deleteStudent(Long id){
        studentRepo.deleteById(id);
    }

    //GET A CATEGORY BY ID
    public Student getStudentById(Long id){
        return studentRepo.findById(id).orElseThrow(null);
    }

    //UPDATE A CATEGORY BY ID
    public void updateStudent(Long id, Student student){
        student.setId(id);
        studentRepo.save(student);
    }
}
