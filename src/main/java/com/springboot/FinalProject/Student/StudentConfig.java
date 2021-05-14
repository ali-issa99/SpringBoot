package com.springboot.FinalProject.Student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repo){
        return args -> {
            Student ali = new Student(
                    1L, "Ali",
                    "ali@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)

            );

            Student alex = new Student(
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2001, Month.JANUARY, 5)

            );

            repo.saveAll(
               List.of(ali,alex)
            );
        };

    }

}
