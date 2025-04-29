package com.example.springbootproject.entities.json;

import com.example.springbootproject.entities.Animal;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"species", "name", "gender", "age", "owner"})
public class AnimalJson {
    @JsonProperty("species")
    private String species;
    @JsonProperty("name")
    private String name;
    @JsonProperty("age")
    private int age;
    @JsonProperty("owner")
    private PersonWithoutAnimalJson owner;

    public AnimalJson() {}

    public AnimalJson(Animal animal) {
        this.species = animal.getSpecies();
        this.name = animal.getName();
        this.age = animal.getAge();
        if (animal.getOwner() != null)
            this.owner = new PersonWithoutAnimalJson(animal.getOwner());
    }
}
