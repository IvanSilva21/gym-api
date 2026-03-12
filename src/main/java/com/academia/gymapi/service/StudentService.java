package com.academia.gymapi.service;

import com.academia.gymapi.model.Student;
import com.academia.gymapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student create(Student student){
        return repository.save(student);
    }

    public List<Student> listAll(){
        return repository.findAll();
    }

    public Student findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
