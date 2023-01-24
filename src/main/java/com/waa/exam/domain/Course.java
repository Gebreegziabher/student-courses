package com.waa.exam.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Course {
    @Id
    private String Id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JsonManagedReference
    //@JoinColumn(name = "courseId")
    private CourseDetails courseDetails;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "courses")
    //@JoinColumn(name = "courseId")
    private List<Student> students;
}
