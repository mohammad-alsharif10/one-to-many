package com.example.demo.controller;

import com.example.demo.database.DoctorRepository;
import com.example.demo.database.PatientRepository;
import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")
@AllArgsConstructor
public class DoctorController {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Doctor saveDoctor(@RequestBody Doctor doctor) {
        List<Patient>patientList=doctor.getPatientList();
        doctor.setPatientList(null);
        Doctor doctor1= doctorRepository.save(doctor);
        patientList.forEach(patient -> {
            patient.setDoctor(doctor1);
            patientRepository.save(patient);
        });
        return doctorRepository.findById(doctor1.getId()).get();
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public Doctor findDoctor(@RequestParam(name = "id") Integer id ) {
       Doctor doctor= doctorRepository.findById(id).get();
       doctor.getPatientList().forEach(patient -> {
           patient.setDoctor(null);
       });
       return doctor;
    }




}
