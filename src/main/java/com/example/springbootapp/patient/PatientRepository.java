package com.example.springbootapp.patient;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// This interface is responsible for data access
// The @Repository annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // SQL (Structured Query Language)
    // @Query(value = "SELECT * FROM patient WHERE email = ?1", nativeQuery = true)

    // JPQL (Java Persistence Query Language)
    @Query("SELECT p FROM Patient p WHERE p.email = ?1")

    // The Optional<Patient> return type indicates that the method may or may not
    // return a Patient object. If no Patient is found with the given email, the
    // Optional will be empty.
    Optional<Patient> findPatientByEmail(String email);
}
