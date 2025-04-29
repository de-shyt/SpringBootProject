package com.example.springbootproject.entities;


public class Person {
    private final Integer id;
    private final String name;
    private final String gender;
    private final Integer age;
    protected Animal animal;

    public Person(int id, String name, String gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Integer getId() {
        return id;
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

    public Animal getAnimal() {
        return animal;
    }
}
