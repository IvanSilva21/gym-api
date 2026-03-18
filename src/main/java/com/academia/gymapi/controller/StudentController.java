package com.academia.gymapi.controller;

import com.academia.gymapi.dto.request.StudentRequestDTO;
import com.academia.gymapi.dto.response.StudentResponseDTO;
import com.academia.gymapi.model.Student;
import com.academia.gymapi.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
    public StudentResponseDTO create(@RequestBody @Valid StudentRequestDTO dto){
        return service.create(dto);
    }

    @GetMapping
    public Page<Student> list(
            @RequestParam(required = false) String name,
            Pageable pageable){

        return service.list(name, pageable);
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