package com.example.springbootproject.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "notes")
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, length = 300)
    String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "auhtor_id", nullable = false)
    Person author;
}
