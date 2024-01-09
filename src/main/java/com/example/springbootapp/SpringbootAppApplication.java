// - Defines the entry point and primary configuration for the Spring Boot app
// - Bootstraps the application using SpringApplication
// - Enables important auto-configuration and component scanning features
package com.example.springbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAppApplication.class, args);
	}

}

// The main application class (SpringbootAppApplication) contains the
// @SpringBootApplication annotation, which marks it as the starting point of
// the application. This configures important auto-configuration features of
// Spring Boot.

// The model class (Patient) defines the data structure for patient objects
// using private fields and accessors. This encapsulates patient data that can
// then be passed between layers.

// The service class (PatientService) is annotated with @Service, indicating it
// handles business logic. It contains a method to retrieve sample patient data.
// This separates data access code from other layers.

// The controller class (PatientController) is annotated with @RestController to
// mark it as a RESTful web controller. It has a dependency on PatientService
// injected via the constructor. The controller exposes an endpoint to retrieve
// patient data by delegating the call to the service class.

// Together, these classes separate concerns into logical layers - the
// controller handles web requests, the service handles data logic, and the
// model defines shared data structures. This is a common approach that Spring
// Boot promotes for building REST APIs in a modular, testable way.