package com.example.springbootproject.entities;

public class Animal {
    private final String species;
    private String name;
    private int age;
    private Person owner;

    public Animal(String species, String name, int age) {
        this.species = species;
        this.name = name;
        this.age = age;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person getOwner() {
        return owner;
    }
}
