package com.example.springbootproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "person"})
public class DatabaseEntryDTO {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("person")
    private PersonDTO person;

    public DatabaseEntryDTO() {}

    public DatabaseEntryDTO(Integer id, PersonDTO person) {
        this.id = id;
        this.person = person;
    }
}
