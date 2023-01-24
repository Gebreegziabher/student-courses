package com.waa.exam.repo;

import com.waa.exam.domain.Student;
import com.waa.exam.domain.dto.StudentDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepo extends CrudRepository<Student, Integer> {
    List<Student> findByGpaLessThanEqual(double gpa);
    @Query("select s from Student s where (select c from s.courses c where (select cd from c.courseDetails cd where cd.program=:program) != null) != null and s.gpa <= :gpa")
    List<Student> findbyJPQA(String program, double gpa);
}
