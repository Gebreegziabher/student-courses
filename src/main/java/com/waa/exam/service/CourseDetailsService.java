package com.waa.exam.service;

import com.waa.exam.domain.CourseDetails;
import com.waa.exam.domain.dto.CourseDetailsDto;
import java.util.List;

public interface CourseDetailsService {
    List<CourseDetailsDto> findAll();
    CourseDetailsDto findById(int id);
    void deleteByid(int id);
    void save(CourseDetailsDto dto);
    void update(int id, CourseDetailsDto courseDetails);
}
