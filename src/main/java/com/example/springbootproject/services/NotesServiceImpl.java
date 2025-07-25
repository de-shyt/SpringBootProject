package com.example.springbootproject.services;

import com.example.springbootproject.dto.NoteDTO;
import com.example.springbootproject.entities.Note;
import com.example.springbootproject.exceptions.NoteNotFoundException;
import com.example.springbootproject.exceptions.PersonNotFoundException;
import com.example.springbootproject.mappers.NoteMapper;
import com.example.springbootproject.repositories.NoteRepo;
import com.example.springbootproject.repositories.PersonRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NotesServiceImpl implements NotesService {
    private final NoteMapper noteMapper;
    private final NoteRepo noteRepo;
    private final PersonRepo personRepo;

    @Override
    public NoteDTO createNote(Long personId, NoteDTO noteDTO) {
        return personRepo.findById(personId)
                .map(author -> {
                    Note note = noteMapper.toNote(noteDTO);
                    note.setAuthor(author);
                    return noteRepo.save(note);
                })
                .map(noteMapper::toNoteDTO)
                .orElseThrow(()  -> new PersonNotFoundException(personId));
    }

    @Override
    public List<NoteDTO> getNotesByAuthorId(Long authorId) {
        return personRepo.findById(authorId)
                .map(author -> noteRepo.findByAuthorId(author.getId()))
                .map(noteMapper::toNoteDTO)
                .orElseThrow(() -> new PersonNotFoundException(authorId));
    }

    @Override
    public NoteDTO updateNote(Long noteId, NoteDTO update) {
        return noteRepo.findById(noteId)
                .map(note -> {
                    note.setContent(update.getContent());
                    return noteRepo.save(note);
                })
                .map(noteMapper::toNoteDTO)
                .orElseThrow(() -> new NoteNotFoundException(noteId));
    }

    @Override
    public void deleteNote(Long noteId) {
        noteRepo.deleteById(noteId);
    }
}
