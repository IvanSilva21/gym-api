package com.academia.gymapi.service;

import com.academia.gymapi.model.Plan;
import com.academia.gymapi.repository.PlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {

    private final PlanRepository repository;

    public PlanService(PlanRepository repository) {
        this.repository = repository;
    }

    public Plan create(Plan plan){
        return repository.save(plan);
    }

    public List<Plan> list(){
        return repository.findAll();
    }

    public Plan findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plano não encontrado"));
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
