package com.waa.exam.domain.dto;

import lombok.Data;

@Data//Getters, RequiredAttributesConstructor, equals, hashcode, toString
public class StudentDto {
    private int id;
    private String name;
    private double gpa;
}
