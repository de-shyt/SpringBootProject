package com.example.springbootproject.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonPropertyOrder({"id", "name", "gender", "age"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PersonDTO {
    private Long id;
    private String name;
    private String gender;
    private int age;
}
