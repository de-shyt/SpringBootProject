package com.example.springbootproject.repositories;

import com.example.springbootproject.entities.Board;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepo extends JpaRepository<Board, Long> {
    @EntityGraph(attributePaths = {
            "notes",
            "notes.author"
    })
    Optional<Board> findWithNotesById(Long id);
}
