package com.example.springbootapp.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// This interface is responsible for data access
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
