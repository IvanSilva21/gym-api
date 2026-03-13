package com.academia.gymapi.controller;

import com.academia.gymapi.model.Plan;
import com.academia.gymapi.service.PlanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plans")
@Tag(name = "Plan", description = "Endpoints for plan management")
public class PlanController {

    private final PlanService service;

    public PlanController(PlanService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Create plan")
    public Plan create(@RequestBody Plan plan){
        return service.create(plan);
    }

    @GetMapping
    public List<Plan> list(){
        return service.list();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find plan by ID")
    public Plan find(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
