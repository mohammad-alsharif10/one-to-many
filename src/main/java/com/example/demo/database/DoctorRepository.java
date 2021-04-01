package com.example.demo.database;

import com.example.demo.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.Doc;

public interface DoctorRepository  extends JpaRepository<Doctor, Integer> {
}
