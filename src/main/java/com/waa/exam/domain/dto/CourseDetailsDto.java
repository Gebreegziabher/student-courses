package com.waa.exam.domain.dto;

import lombok.Data;

import java.time.LocalTime;

@Data//Getters, RequiredAttributesConstructor, equals, hashcode, toString
public class CourseDetailsDto {
    private int id;
    private String description;
    private int credit;
    private String program;
    private LocalTime lastUpdate;
}
