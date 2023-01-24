package com.waa.exam.controller;

import com.waa.exam.domain.Course;
import com.waa.exam.domain.dto.CourseDto;
import com.waa.exam.domain.dto.StudentDto;
import com.waa.exam.service.CourseService;
import com.waa.exam.service.Impl.CourseServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private CourseService service;
    public CourseController(CourseService service){
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Course> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseDto findById(@PathVariable(value = "id") String id){
        return service.findById(id);
    }

    @GetMapping("/{id}/courses")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDto> findStudentsById(@PathVariable(value = "id") String id){
        return service.findStudentsById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody CourseDto dto){
        service.save(dto);
    }
}
