package com.example.demo.controller;

import com.example.demo.database.DoctorRepository;
import com.example.demo.database.PatientRepository;
import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/patient")
@AllArgsConstructor
public class PatientController  {

    private  final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @RequestMapping(value = "save",method = RequestMethod.POST)
    Patient savePatient(@RequestBody Patient patient){
        Optional<Doctor> doctor= doctorRepository.findById(patient.getDoctor().getId());
        patient.setDoctor(doctor.get());
       return patientRepository.save(patient);
    }
}
