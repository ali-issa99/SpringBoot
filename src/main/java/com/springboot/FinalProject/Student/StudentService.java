package com.springboot.FinalProject.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class StudentService {

    private final StudentRepository studentRepository;


    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents() {

        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {

        Optional<Student> studentOptinal = studentRepository.findStudentByEmail(student.getEmail());



        if (studentOptinal.isPresent()) {

            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean exists = studentRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("student" + id + "does not exist");
        }
        studentRepository.deleteById(id);

    }

    @Transactional
    public void updateStudent(Long id,  String name, String email) {

       Student student=studentRepository.findById(id)
        .orElseThrow(() ->  new IllegalStateException("student" + id + "does not exist"));


       if(name!=null && name.length() > 0 && !Objects.equals(student.getName(),name)){
             student.setName(name);
       }


       if(email!=null && email.length() > 0 && !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptinal = studentRepository.findStudentByEmail(student.getEmail());


            if (!studentOptinal.isPresent()) {

                throw new IllegalStateException("email taken");
            }

            student.setEmail(email);

        }






    }
}
