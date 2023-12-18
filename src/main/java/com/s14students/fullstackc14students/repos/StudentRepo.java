package com.s14students.fullstackc14students.repos;

import com.s14students.fullstackc14students.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long> {
}
