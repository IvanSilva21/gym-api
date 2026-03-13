package com.academia.gymapi.controller;

import com.academia.gymapi.dto.request.StudentRequestDTO;
import com.academia.gymapi.dto.response.StudentResponseDTO;
import com.academia.gymapi.model.Student;
import com.academia.gymapi.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@Tag(name = "Students", description = "Endpoints for student management")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Create student")
    public StudentResponseDTO create(@RequestBody StudentRequestDTO dto){
        return service.create(dto);
    }

    @GetMapping
    public List<Student> list(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find student by ID")
    public Student find(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}