// This class serves as a controller for patient-related operations in the Spring Boot application.
// Some common uses of a controller class like this include:
// - Handling incoming HTTP requests related to patients
// - Defining API endpoints for CRUD operations
// - Facilitating the interaction between clients and the patient service layer

package com.example.springbootapp.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/patient")
public class PatientController {

    private final PatientService patientService;

    // public PatientController(PatientService patientService) {
    // this.patientService = new PatientService();
    // }

    // constructor
    // @Autowired tells Spring that it should automatically inject an instance of
    // PatientService when creating an instance of PatientController.
    // So we don't need to instatiate the object with `new PatientService()`.
    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> getPatients() {
        return patientService.getPatients();
    }

    @PostMapping
    public void registerNewPatient(@RequestBody Patient patient) {
        patientService.addNewPatient(patient);

    }

    @DeleteMapping(path = "{patientId}")
    public void deletePatient(@PathVariable("patientId") Long patientId) {
        patientService.deletePatient(patientId);
    }

    @PutMapping(path = "{patientId}")
    public void updatePatient(
            @PathVariable("patientId") Long patientId,
            @RequestBody(required = false) Patient updatedPatient) {
        patientService.updatePatient(patientId, updatedPatient);
    }

}
