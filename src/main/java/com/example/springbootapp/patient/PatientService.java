// The service class (PatientService) is annotated with @Service, indicating it handles business logic.
// It contains a method to retrieve sample patient data.
// This separates data access code from other layers.
// This separates data access code from other layers
package com.example.springbootapp.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }
}
