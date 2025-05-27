package com.example.springbootproject.mappers;

import com.example.springbootproject.dto.NoteDTO;
import com.example.springbootproject.entities.Note;
import com.example.springbootproject.entities.Person;

import java.util.List;

public class NoteMapper {
    public static NoteDTO toNodeDTO(Note note) {
        return NoteDTO.builder()
                .id(note.getId())
                .content(note.getContent())
                .author(PersonMapper.toPersonDTO(note.getAuthor()))
                .build();
    }

    public static List<NoteDTO> toNodeDTO(List<Note> notes) {
        return notes.stream()
                .map(NoteMapper::toNodeDTO)
                .toList();
    }

    public static Note toNote(NoteDTO dto) {
        return Note.builder()
                .content(dto.getContent())
                .author(PersonMapper.toPerson(dto.getAuthor()))
                .build();
    }

    public static Note toNote(NoteDTO dto, Person author) {
        return Note.builder()
                .content(dto.getContent())
                .author(author)
                .build();
    }
}
