package com.academia.gymapi.service;

import com.academia.gymapi.dto.request.StudentRequestDTO;
import com.academia.gymapi.dto.response.StudentResponseDTO;
import com.academia.gymapi.exception.ResourceNotFoundException;
import com.academia.gymapi.model.Student;
import com.academia.gymapi.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    private StudentResponseDTO toDTO(Student student){
        return StudentResponseDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .email(student.getEmail())
                .phone(student.getPhone())
                .age(student.getAge())
                .build();
    }

    public StudentResponseDTO create(StudentRequestDTO dto){

        Student student = Student.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .age(dto.getAge())
                .build();

        student = repository.save(student);

        return StudentResponseDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .email(student.getEmail())
                .phone(student.getPhone())
                .age(student.getAge())
                .build();
    }

    public Page<StudentResponseDTO> list(String name, Pageable pageable){

        Page<Student> students;

        if (name != null && !name.isEmpty()) {
            students = repository.findByNameContainingIgnoreCase(name, pageable);
        } else {
            students = repository.findAll(pageable);
        }

        return students.map(this::toDTO);
    }

    public Student findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
