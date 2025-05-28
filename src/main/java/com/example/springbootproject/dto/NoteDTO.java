package com.example.springbootproject.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import lombok.experimental.FieldDefaults;

@JsonPropertyOrder({"id", "content", "author"})
@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NoteDTO {
    Long id;
    String content;
    PersonDTO author;
}