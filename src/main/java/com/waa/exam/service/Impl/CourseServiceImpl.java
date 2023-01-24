package com.waa.exam.service.Impl;

import com.waa.exam.domain.Course;
import com.waa.exam.domain.Student;
import com.waa.exam.domain.dto.CourseDto;
import com.waa.exam.domain.dto.StudentDto;
import com.waa.exam.repo.CourseRepo;
import com.waa.exam.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepo repo;
    private ModelMapper modelMapper;
    public CourseServiceImpl(CourseRepo repo, ModelMapper modelMapper){
        this.repo = repo;
        this.modelMapper = modelMapper;
    }
    public List<Course> findAll(){
        List<Course> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list;
        //return list.stream().map(m -> modelMapper.map(m, CourseDto.class)).collect(Collectors.toList());
    }
    public CourseDto findById(String id){
        return modelMapper.map(repo.findById(id).get(), CourseDto.class);
    }

    public List<StudentDto> findStudentsById(String id){
        List<Student> students = repo.findById(id).get().getStudents();
        return students.stream().map(m -> modelMapper.map(m, StudentDto.class)).collect(Collectors.toList());
    }
    public void deleteByid(String id){
        repo.deleteById(id);
    }
    public void save(CourseDto dto){
        Course course = new Course();
        course.setId(dto.getId());
        course.setName(dto.getName());
        repo.save(course);
    }
    public void update(String id, CourseDto courseDto){
        //TO DO: to implement in Repo
    }
}
