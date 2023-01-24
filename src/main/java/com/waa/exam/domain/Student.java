package com.waa.exam.domain;

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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double gpa;
    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "addressId")
    private Address address;

    @ManyToMany(fetch = FetchType.LAZY)
    //@JoinColumn(name = "studentId")
    private List<Course> courses;
}
