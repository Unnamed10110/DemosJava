package com.unnamed.demoREST.rest;

import com.unnamed.demoREST.Models.CustomResponseModel;
import com.unnamed.demoREST.Exceptions.StudentNotFoundException;
import com.unnamed.demoREST.Entities.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private ArrayList<Student> students=new ArrayList<Student>();

    @PostConstruct
    public void loadData(){
        students.add(new Student("pepe","lopez"));
        students.add(new Student("john","nicanor"));
        students.add(new Student("hannah","burcaw"));
    }
    public StudentRestController() {
    }

    @GetMapping("/students")
    public ResponseEntity<CustomResponseModel> getStudents(){
        return new ResponseEntity<CustomResponseModel>(new CustomResponseModel(HttpStatus.OK.value(), students,System.currentTimeMillis()),HttpStatus.OK);
    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<CustomResponseModel> getStudent(@PathVariable int studentId){
        try {
            return new ResponseEntity<CustomResponseModel>(new CustomResponseModel(HttpStatus.OK.value(), students.get(studentId),System.currentTimeMillis()),HttpStatus.OK);
        }catch (Exception ex){
            throw  new StudentNotFoundException("Student not found - "+ studentId);
        }
    }

}
