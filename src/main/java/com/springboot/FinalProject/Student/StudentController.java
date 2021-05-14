package com.springboot.FinalProject.Student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController //makes the class serve endpoints

public class StudentController {



    private final StudentService studentservice;


    @Autowired
    public StudentController(StudentService studentservice) {
        this.studentservice = studentservice;
    }




    //restfull point
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public List<Student> getStudents() {
        return studentservice.getStudents();
    }


    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public  void RegisterNewStudent(@RequestBody Student student){
        studentservice.addNewStudent(student);

    }
    @RequestMapping(value = "/students/{studentId}", method = RequestMethod.DELETE)
    public void DeleteStudent(@PathVariable("studentId") long studentId){
        studentservice.deleteStudent(studentId);



    }
    @RequestMapping(value = "/students/{studentId}", method = RequestMethod.PUT)
    public void UpdateStudent(
            @PathVariable("studentId") Long studentid,
             @RequestParam(required=false) String name,
            @RequestParam(required=false) String email

            ){

        studentservice.updateStudent(studentid,name,email);







    }
}
