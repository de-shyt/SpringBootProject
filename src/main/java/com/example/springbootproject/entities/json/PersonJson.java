package com.example.springbootproject.entities.json;

import com.example.springbootproject.entities.Person;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "name", "gender", "age", "animal"})
public class PersonJson {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("age")
    private int age;
    @JsonProperty("animal")
    protected AnimalWithoutOwnerJson animal;

    public PersonJson() {}

    public PersonJson(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.gender = person.getGender();
        this.age = person.getAge();
        if (person.getAnimal() != null)
            this.animal = new AnimalWithoutOwnerJson(person.getAnimal());
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}
