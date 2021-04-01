package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String name;

    private Integer age;

    @OneToMany(
            mappedBy = "doctor",
            cascade = CascadeType.ALL,
            targetEntity = Patient.class
    )
    private List<Patient> patientList = new ArrayList<>();
}
