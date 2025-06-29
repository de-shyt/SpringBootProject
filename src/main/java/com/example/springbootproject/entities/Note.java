package com.example.springbootproject.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "notes")
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

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    Person author;

    @ManyToMany(mappedBy = "notes")
    List<Board> boards;
}
