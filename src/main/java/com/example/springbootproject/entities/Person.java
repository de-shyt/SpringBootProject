package com.example.springbootproject.entities;

import jakarta.persistence.*;
import lombok.*;

//@Data
@Entity
@Table(name = "persons")
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 12)
    private String gender;
    @Column(nullable = false)
    private Integer age;
}
