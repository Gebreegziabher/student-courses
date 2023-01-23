package com.waa.exam.repo;

import com.waa.exam.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student, Integer> {
}
