package com.waa.exam.service;

import com.waa.exam.domain.dto.CourseDto;
import com.waa.exam.domain.dto.StudentDto;
import java.util.List;

public interface StudentService {
    List<StudentDto> findAll();
    StudentDto findById(int id);
    List<CourseDto> findCoursesById(int id);
    List<StudentDto> findByGpaLessThanEqual(double gpa);
    List<StudentDto> findbyJPQA(String program, double gpa);
    List<StudentDto> findByCriteria(String program, Double gpa);
    void deleteByid(int id);
    void save(StudentDto studentDto);
    void update(int id, StudentDto studentDto);
}
