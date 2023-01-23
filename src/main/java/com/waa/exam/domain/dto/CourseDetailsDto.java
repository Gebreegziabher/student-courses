package com.waa.exam.domain.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Data//Getters, RequiredAttributesConstructor, equals, hashcode, toString
public class CourseDetailsDto {
    private int id;
    private String description;
    private int credit;
    private String program;
    private LocalTime lastUpdate;
}
