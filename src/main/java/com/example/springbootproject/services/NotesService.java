package com.example.springbootproject.services;

import com.example.springbootproject.dto.NoteDTO;

import java.util.List;

public interface NotesService {
    NoteDTO createNote(Long personId, NoteDTO noteDTO);
    List<NoteDTO> getNotesByAuthorId(Long authorId);
    NoteDTO updateNote(Long noteId, NoteDTO update);
    void deleteNote(Long noteId);
}
