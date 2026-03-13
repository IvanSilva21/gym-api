package com.academia.gymapi.controller;

import com.academia.gymapi.dto.request.MembershipRequestDTO;
import com.academia.gymapi.model.Membership;
import com.academia.gymapi.service.MembershipService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/memberships")
@Tag(name = "Membership", description = "Endpoint for membership management")
public class MembershipController {

    private final MembershipService service;

    public MembershipController(MembershipService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Create membership")
    public Membership create(@RequestBody MembershipRequestDTO dto){
        return service.create(dto);
    }
}
