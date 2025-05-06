package com.example.springbootproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonPropertyOrder({"id", "name", "gender", "age", "animal"})
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PersonDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("age")
    private int age;
}
