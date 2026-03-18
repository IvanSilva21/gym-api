package com.academia.gymapi.service;

import com.academia.gymapi.dto.request.MembershipRequestDTO;
import com.academia.gymapi.exception.ResourceNotFoundException;
import com.academia.gymapi.model.*;
import com.academia.gymapi.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MembershipService {

    private final MembershipRepository membershipRepository;
    private final StudentRepository studentRepository;
    private final PlanRepository planRepository;

    public MembershipService(MembershipRepository membershipRepository,
                             StudentRepository studentRepository,
                             PlanRepository planRepository) {

        this.membershipRepository = membershipRepository;
        this.studentRepository = studentRepository;
        this.planRepository = planRepository;
    }

    public Membership create(MembershipRequestDTO dto){

        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        Plan plan = planRepository.findById(dto.getPlanId())
                .orElseThrow(() -> new ResourceNotFoundException("Plan not found"));

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(plan.getDurationInDays());

        Membership membership = Membership.builder()
                .student(student)
                .plan(plan)
                .startDate(startDate)
                .endDate(endDate)
                .build();

        return membershipRepository.save(membership);
    }
}