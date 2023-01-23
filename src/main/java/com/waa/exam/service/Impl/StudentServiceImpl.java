package com.waa.exam.service.Impl;

import com.waa.exam.domain.Student;
import com.waa.exam.domain.dto.StudentDto;
import com.waa.exam.repo.CourseRepo;
import com.waa.exam.repo.StudentRepo;
import com.waa.exam.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepo repo;
    private ModelMapper modelMapper;
    public StudentServiceImpl(StudentRepo repo, ModelMapper modelMapper){
        this.repo = repo;
        this.modelMapper = modelMapper;
    }
    public List<StudentDto> findAll(){
        List<Student> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list.stream().map(m -> modelMapper.map(m, StudentDto.class)).collect(Collectors.toList());
    }
    public StudentDto findById(int id){
        return modelMapper.map(repo.findById(id), StudentDto.class);
    }
    public void deleteByid(int id){
        repo.deleteById(id);
    }
    public void save(StudentDto dto){
        Student student = new Student();
        student.setGpa(student.getGpa());
        student.setName(student.getName());
        repo.save(student);
    }
    public void update(int id, StudentDto studentDto){

    }
}
