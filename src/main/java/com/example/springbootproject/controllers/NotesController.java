package com.example.springbootproject.controllers;

import com.example.springbootproject.dto.NoteDTO;
import com.example.springbootproject.services.NotesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("notes")
@AllArgsConstructor
public class NotesController {
    private final NotesService service;

    @PostMapping("addNote")
    public NoteDTO addNote(@RequestParam("personId") Long personId, @RequestBody NoteDTO noteDTO) {
        return service.createNote(personId, noteDTO);
    }

    @GetMapping("allNotes")
    public List<NoteDTO> getNotesByPersonId(@RequestParam("personId") Long personId) {
        return service.getNotesByPersonId(personId);
    }

    @PutMapping("updateNote")
    public NoteDTO updateNote(@RequestParam("noteId") Long noteId, @RequestBody NoteDTO noteDTO) {
        return service.updateNote(noteId, noteDTO);
    }

    @DeleteMapping("removeNote")
    public void removeNoteById(@RequestParam("noteId") Long noteId) {
        service.deleteNote(noteId);
    }
}
