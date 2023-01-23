package com.waa.exam.repo;

import com.waa.exam.domain.Address;
import com.waa.exam.domain.CourseDetails;
import org.springframework.data.repository.CrudRepository;

public interface CourseDetailsRepo extends CrudRepository<CourseDetails, Integer> {
}
