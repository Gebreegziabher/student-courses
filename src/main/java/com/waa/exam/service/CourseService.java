package com.waa.exam.service;

import com.waa.exam.domain.dto.CourseDto;
import java.util.List;

public interface CourseService {
    List<CourseDto> findAll();
    CourseDto findById(String id);
    void deleteByid(String id);
    void save(CourseDto courseDto);
    void update(String id, CourseDto courseDto);
}
