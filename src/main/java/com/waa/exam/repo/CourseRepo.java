package com.waa.exam.repo;

import com.waa.exam.domain.Address;
import com.waa.exam.domain.Course;
import org.springframework.data.repository.CrudRepository;


public interface CourseRepo extends CrudRepository<Course, String> {
}