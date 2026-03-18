package com.academia.gymapi.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class StudentRequestDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Phone is required")
    private String phone;

    @Min(value = 1, message = "Age must be greater than 0")
    private Integer age;
}