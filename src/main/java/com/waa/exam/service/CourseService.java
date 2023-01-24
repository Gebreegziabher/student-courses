package com.waa.exam.service;

import com.waa.exam.domain.Course;
import com.waa.exam.domain.dto.CourseDto;
import com.waa.exam.domain.dto.StudentDto;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
    CourseDto findById(String id);
    List<StudentDto> findStudentsById(String id);
    void deleteByid(String id);
    void save(CourseDto courseDto);
    void update(String id, CourseDto courseDto);
}
