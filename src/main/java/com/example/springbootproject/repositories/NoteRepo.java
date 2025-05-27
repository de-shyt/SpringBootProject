package com.example.springbootproject.repositories;

import com.example.springbootproject.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepo extends JpaRepository<Note, Long> {
    List<Note> findByAuthorId(Long authorId);
}
