package com.example.demo.database;

import com.example.demo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository  extends JpaRepository<Patient,Integer> {
}
