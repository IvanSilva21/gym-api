package com.academia.gymapi.repository;

import com.academia.gymapi.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}