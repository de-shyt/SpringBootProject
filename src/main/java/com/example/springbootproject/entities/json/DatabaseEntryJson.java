package com.example.springbootproject.entities.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "person"})
public class DatabaseEntryJson {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("person")
    private PersonJson person;

    public DatabaseEntryJson() {}

    public DatabaseEntryJson(Integer id, PersonJson person) {
        this.id = id;
        this.person = person;
    }
}
