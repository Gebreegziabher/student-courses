package com.waa.exam.controller;

import com.waa.exam.domain.dto.CourseDto;
import com.waa.exam.domain.dto.StudentDto;
import com.waa.exam.service.Impl.StudentServiceImpl;
import com.waa.exam.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private StudentService service;
    public StudentController(StudentService service){
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDto> findAll(@RequestParam(value = "gpa", required = false) Double gpa,
                                    @RequestParam(value = "program", required = false) String program){
        return gpa != null && program != null ? service.findByCriteria(program, gpa) : gpa == null ? service.findAll() : service.findByGpaLessThanEqual(gpa);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentDto findById(@PathVariable(value = "id") Integer id){
        return service.findById(id);
    }

    @GetMapping("/{id}/courses")
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDto> findCoursesById(@PathVariable(value = "id") Integer id){
        return service.findCoursesById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody StudentDto dto){
        service.save(dto);
    }
}
