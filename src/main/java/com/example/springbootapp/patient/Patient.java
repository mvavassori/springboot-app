// This class encapsulates the data and attributes of a patient into a reusable Patient object.
// Some common uses of a model class like this include:
// - Mapping database records to objects
// - Passing patient data between layers/services
// - Serializing to/from JSON for REST APIs
package com.example.springbootapp.patient;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Patient {
    @Id
    @SequenceGenerator(name = "patient_sequence", sequenceName = "patient_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_sequence")
    private Long id;
    private String name;
    private String email;
    private LocalDate dob; // date of birth
    private Integer age;

    // Constructor 1
    public Patient() {
    }

    // Constructor 2
    public Patient(Long id, String name,
            String email,
            LocalDate dob,
            Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }

    // Constructor 3
    public Patient(String name,
            String email,
            LocalDate dob,
            Integer age) {

        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    // toString
    @Override
    public String toString() {
        return "Patient [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", age=" + age + "]";
    }

}
