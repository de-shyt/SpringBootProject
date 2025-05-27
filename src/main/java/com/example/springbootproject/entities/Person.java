package com.example.springbootproject.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "persons")
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, length = 20)
    String name;

    @Column(nullable = false, length = 12)
    String gender;

    @Column(nullable = false)
    Integer age;

    @OneToMany(mappedBy = "author")
    List<Note> notes;
}
