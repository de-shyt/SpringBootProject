package com.example.springbootproject.mappers;

import com.example.springbootproject.dto.NoteDTO;
import com.example.springbootproject.entities.Note;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface NoteMapper {
    NoteDTO toNoteDTO(Note note);
    List<NoteDTO> toNoteDTO(List<Note> notes);
    Note toNote(NoteDTO noteDTO);
}
