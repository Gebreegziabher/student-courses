package com.waa.exam.service.Impl;

import com.waa.exam.domain.CourseDetails;
import com.waa.exam.domain.dto.CourseDetailsDto;
import com.waa.exam.repo.CourseDetailsRepo;
import com.waa.exam.service.CourseDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseDetailsServiceImpl implements CourseDetailsService {
    private CourseDetailsRepo repo;
    private ModelMapper modelMapper;
    public CourseDetailsServiceImpl(CourseDetailsRepo repo, ModelMapper modelMapper){
        this.repo = repo;
        this.modelMapper = modelMapper;
    }
    public List<CourseDetailsDto> findAll(){
        List<CourseDetails> list = new ArrayList();
        repo.findAll().forEach(list::add);
        return list.stream().map(m -> modelMapper.map(m, CourseDetailsDto.class)).collect(Collectors.toList());
    }
    public CourseDetailsDto findById(int id){
        return modelMapper.map(repo.findById(id).get(), CourseDetailsDto.class);
    }
    public void deleteByid(int id){
        repo.deleteById(id);
    }
    public void save(CourseDetailsDto dto){
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setCredit(dto.getCredit());
        courseDetails.setProgram(dto.getProgram());
        courseDetails.setDescription(dto.getDescription());
        courseDetails.setLastUpdate(dto.getLastUpdate());
        repo.save(courseDetails);
    }

    public void update(int id, CourseDetailsDto courseDetails){
        //TO DO: custom code in Repo
    }
}
