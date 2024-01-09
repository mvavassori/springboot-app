// - PatientController handles web requests
// - It uses PatientService to retrieve the data
// - PatientService focuses only on data access logic
package com.example.springbootapp.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/patient")
public class PatientController {

    private final PatientService patientService;

    // public PatientController(PatientService patientService) {
    // this.patientService = new PatientService();
    // }

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
}
