package com.example.springbootproject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Person {
    private final Long id;
    private final String name;
    private final String gender;
    private final Integer age;
}
