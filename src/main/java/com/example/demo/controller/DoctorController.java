package com.example.demo.controller;

import com.example.demo.database.DoctorRepository;
import com.example.demo.model.Doctor;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/doctor")
@AllArgsConstructor
public class DoctorController {

    private final DoctorRepository doctorRepository;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Doctor saveDoctor(@RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public Optional<Doctor> findDoctor(@RequestParam(name = "id") Integer id ) {
        return doctorRepository.findById(id);
    }




}
