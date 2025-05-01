package com.example.springbootproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonPropertyOrder({"id", "person"})
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DatabaseEntryDTO {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("person")
    private PersonDTO person;
}
