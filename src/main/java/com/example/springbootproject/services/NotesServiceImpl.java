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
public class NotesServiceImpl implements NotesService {
    private final NoteRepo noteRepo;
    private final PersonRepo personRepo;

    @Override
    public NoteDTO createNote(Long personId, NoteDTO noteDTO) {
        return personRepo.findById(personId)
                .map(author -> {
                    Note note = NoteMapper.toNote(noteDTO, author);
                    return noteRepo.save(note);
                })
                .map(NoteMapper::toNodeDTO)
                .orElse(null);
    }

    @Override
    public List<NoteDTO> getNotesByAuthorId(Long authorId) {
        return personRepo.findById(authorId)
                .map(author -> noteRepo.findByAuthorId(author.getId()))
                .map(NoteMapper::toNodeDTO)
                .orElse(null);
    }

    @Override
    public NoteDTO updateNote(Long noteId, NoteDTO update) {
        return noteRepo.findById(noteId)
                .map(note -> {
                    note.setContent(update.getContent());
                    return noteRepo.save(note);
                })
                .map(NoteMapper::toNodeDTO)
                .orElse(null);
    }

    @Override
    public void deleteNote(Long noteId) {
        noteRepo.deleteById(noteId);
    }
}
