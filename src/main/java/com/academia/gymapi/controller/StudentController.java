package com.academia.gymapi.controller;

import com.academia.gymapi.model.Student;
import com.academia.gymapi.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public Student create(@RequestBody Student student){
        return service.create(student);
    }

    @GetMapping
    public List<Student> list(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public Student find(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}