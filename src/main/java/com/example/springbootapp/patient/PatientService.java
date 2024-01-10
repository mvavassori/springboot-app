// This class acts as a service layer for managing patient-related business logic in the application.
// Some common uses of a service class like this include:
// - Implementing business rules and logic for patient operations
// - Acting as an intermediary between the controller and repository layers
// - Encapsulating the application's core functionality related to patients

package com.example.springbootapp.patient;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

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

    public void addNewPatient(Patient patient) {
        Optional<Patient> patientOptional = patientRepository.findPatientByEmail(patient.getEmail());
        if (patientOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        patientRepository.save(patient);
    }

    public void deletePatient(Long patientId) {
        boolean exists = patientRepository.existsById(patientId);
        if (!exists) {
            throw new IllegalStateException("patient with id " + patientId + " does not exist");
        }
        patientRepository.deleteById(patientId);
    }

    @Transactional
    public void updatePatient(Long patientId, Patient updatedPatient) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new IllegalStateException("patient with id " + patientId + " does not exist"));

        String updatedName = updatedPatient.getName();
        String updatedEmail = updatedPatient.getEmail();

        if (updatedName != null && updatedName.length() > 0 && !patient.getName().equals(updatedName)) {
            patient.setName(updatedName);
        }

        if (updatedEmail != null && updatedEmail.length() > 0 && !patient.getEmail().equals(updatedEmail)) {
            Optional<Patient> patientOptional = patientRepository.findPatientByEmail(updatedEmail);
            if (patientOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }

            patient.setEmail(updatedEmail);
        }

        // handle other attributes if needed

        // save updated patient to db
        patientRepository.save(patient);
    }
}
