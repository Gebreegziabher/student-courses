package com.waa.exam.service.Impl;

import com.waa.exam.domain.Course;
import com.waa.exam.domain.dto.CourseDto;
import com.waa.exam.repo.AddressRepo;
import com.waa.exam.repo.CourseRepo;
import com.waa.exam.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
    public List<CourseDto> findAll(){
        List<Course> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list.stream().map(m -> modelMapper.map(m, CourseDto.class)).collect(Collectors.toList());
    }
    public CourseDto findById(String id){
        return modelMapper.map(repo.findById(id), CourseDto.class);
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
