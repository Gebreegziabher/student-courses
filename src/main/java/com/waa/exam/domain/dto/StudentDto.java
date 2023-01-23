package com.waa.exam.domain.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data//Getters, RequiredAttributesConstructor, equals, hashcode, toString
public class StudentDto {
    private int id;
    private String name;
    private double gpa;
}
