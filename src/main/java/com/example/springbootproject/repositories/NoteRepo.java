package com.example.springbootproject.repositories;

import com.example.springbootproject.entities.Note;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoteRepo extends JpaRepository<Note, Long> {
    @EntityGraph(attributePaths = {"author"})
    Optional<Note> findWithAuthorById(Long id);

    List<Note> findByAuthorId(Long authorId);
}
