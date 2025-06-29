package com.example.springbootproject.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@JsonPropertyOrder({"id", "ownerId", "description", "notes"})
@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BoardDTO {
    Long id;
    Long ownerId;
    String description;
    List<NoteDTO> notes;
}
