package com.academia.gymapi.dto.request;

import lombok.Data;

@Data
public class StudentRequestDTO {

    private String name;
    private String email;
    private String phone;
    private Integer age;
}