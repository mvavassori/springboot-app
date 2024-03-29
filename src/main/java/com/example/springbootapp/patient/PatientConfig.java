// This class is a configuration class that provides settings and setup for the patient feature.
// Some common uses of a configuration class like this include:
// - Defining specific beans or components related to patient functionality
// - Including any additional configuration settings for the patient module
// - Serving as a central place for configuring and initializing patient-related components

package com.example.springbootapp.patient;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class PatientConfig {

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository repository) {
        return args -> {

            Patient john = new Patient(
                    "John",
                    "john.doe@example.com",
                    LocalDate.of(2000, Month.JANUARY, 1));
            Patient mary = new Patient(
                    "Mary",
                    "mary.doe@example.com",
                    LocalDate.of(2004, Month.JANUARY, 1));

            repository.saveAll(List.of(john, mary));
        };
    }
}
