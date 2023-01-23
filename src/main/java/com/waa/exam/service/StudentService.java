package com.waa.exam.service;

import com.waa.exam.domain.dto.StudentDto;
import java.util.List;

public interface StudentService {
    List<StudentDto> findAll();
    StudentDto findById(int id);
    void deleteByid(int id);
    void save(StudentDto studentDto);
    void update(int id, StudentDto studentDto);
}
