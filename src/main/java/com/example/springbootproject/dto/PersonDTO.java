package com.example.springbootproject.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import lombok.experimental.FieldDefaults;

@JsonPropertyOrder({"id", "name", "gender", "age"})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonDTO {
    Long id;
    String name;
    String gender;
    int age;
}
