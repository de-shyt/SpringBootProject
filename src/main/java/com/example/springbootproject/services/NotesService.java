package com.example.springbootproject.services;

import com.example.springbootproject.dto.NoteDTO;
import com.example.springbootproject.entities.Note;
import com.example.springbootproject.mappers.NoteMapper;
import com.example.springbootproject.repositories.NoteRepo;
import com.example.springbootproject.repositories.PersonRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NotesService {
    private final NoteRepo noteRepo;
    private final PersonRepo personRepo;

    public NoteDTO createNote(Long personId, NoteDTO noteDTO) {
        return personRepo.findById(personId)
                .map(author -> {
                    Note note = NoteMapper.toNote(noteDTO, author);
                    return noteRepo.save(note);
                })
                .map(NoteMapper::toNodeDTO)
                .orElse(null);
    }

    public List<NoteDTO> getNotesByPersonId(Long personId) {
        return personRepo.findById(personId)
                .map(author -> noteRepo.findByAuthorId(author.getId()))
                .map(NoteMapper::toNodeDTO)
                .orElse(null);
    }

    public NoteDTO updateNote(Long noteId, NoteDTO update) {
        return noteRepo.findById(noteId)
                .map(note -> {
                    note.setContent(update.getContent());
                    return noteRepo.save(note);
                })
                .map(NoteMapper::toNodeDTO)
                .orElse(null);
    }

    public void deleteNote(Long noteId) {
        noteRepo.deleteById(noteId);
    }
}
