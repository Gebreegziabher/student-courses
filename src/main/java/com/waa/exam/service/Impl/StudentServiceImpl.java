package com.waa.exam.service.Impl;

import com.waa.exam.domain.Student;
import com.waa.exam.domain.dto.CourseDto;
import com.waa.exam.domain.dto.StudentDto;
import com.waa.exam.repo.StudentRepo;
import com.waa.exam.service.StudentService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    private StudentRepo repo;
    private ModelMapper modelMapper;
    @PersistenceContext
    EntityManager entityManager;

    public StudentServiceImpl(StudentRepo repo, ModelMapper modelMapper){
        this.repo = repo;
        this.modelMapper = modelMapper;
    }
    public List<StudentDto> findAll(){
        List<Student> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list.stream().map(m -> modelMapper.map(m, StudentDto.class)).collect(Collectors.toList());
    }
    public List<CourseDto> findCoursesById(int id){
        Student student = repo.findById(id).get();
        return student.getCourses().stream().map(m -> modelMapper.map(m, CourseDto.class)).collect(Collectors.toList());
    }
    public List<StudentDto> findByGpaLessThanEqual(double gpa){
        List<Student> list = new ArrayList<>();
        repo.findByGpaLessThanEqual(gpa).forEach(list::add);
        return list.stream().map(m -> modelMapper.map(m, StudentDto.class)).collect(Collectors.toList());
    }

    public List<StudentDto> findbyJPQA(String program, double gpa){
        List<Student> list = new ArrayList<>();
        var result = repo.findbyJPQA(program, gpa);
        repo.findbyJPQA(program,gpa).forEach(list::add);
        return list.stream().map(m -> modelMapper.map(m, StudentDto.class)).collect(Collectors.toList());
    }

    public List<StudentDto> findByCriteria(String program, Double gpa){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        List<Predicate> predicates = new ArrayList<>();

        Root<Student> root = criteriaQuery.from(Student.class);
        if(program != null){
            Join<Object, Object> coursesJoin = root.join( "courses" );
            Join<Object, Object> courseDetailsJoin = coursesJoin.join( "courseDetails" );
            Predicate programPredicate = criteriaBuilder.equal(courseDetailsJoin.get("program"), program);
            predicates.add(programPredicate);
        }

        if(gpa != null){
            Predicate gpaPredicate = criteriaBuilder.lessThanOrEqualTo(root.get("gpa"), gpa);
            predicates.add(gpaPredicate);
        }

        criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
        TypedQuery<Student> query = entityManager.createQuery(criteriaQuery);
        //String queryJ = query.unwrap(org.hibernate.Query.class).getQueryString()
        return query.getResultList().stream().map(m -> modelMapper.map(m, StudentDto.class)).collect(Collectors.toList());
    }

    public StudentDto findById(int id){
        return modelMapper.map(repo.findById(id).get(), StudentDto.class);
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
