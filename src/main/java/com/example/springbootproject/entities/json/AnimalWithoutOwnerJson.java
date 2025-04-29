package com.example.springbootproject.entities.json;

import com.example.springbootproject.entities.Animal;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"species", "name", "gender", "age"})
public class AnimalWithoutOwnerJson {
    @JsonProperty("species")
    private String species;
    @JsonProperty("name")
    private String name;
    @JsonProperty("age")
    private int age;

    public AnimalWithoutOwnerJson() {}

    public AnimalWithoutOwnerJson(Animal animal) {
        this.species = animal.getSpecies();
        this.name = animal.getName();
        this.age = animal.getAge();
    }
}

