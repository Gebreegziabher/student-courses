package com.waa.exam.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class CourseDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private int credit;
    private String program;
    private LocalTime lastUpdate;

    @OneToOne(mappedBy = "courseDetails")//(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Course course;
}
