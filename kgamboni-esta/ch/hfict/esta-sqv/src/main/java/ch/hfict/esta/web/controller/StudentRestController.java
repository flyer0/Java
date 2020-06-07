package ch.hfict.esta.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.hfict.esta.core.domain.Student;
import ch.hfict.esta.core.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {

    @Autowired
    StudentService studentService;
    
    @GetMapping
    public List<Student> findAll(){
        return studentService.findAll();
    }
}
