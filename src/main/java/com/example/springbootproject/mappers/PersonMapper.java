package com.example.springbootproject.mappers;

import com.example.springbootproject.dto.PersonDTO;
import com.example.springbootproject.entities.Person;

import java.util.List;

public class PersonMapper {
    public static PersonDTO toPersonDTO(Person person) {
        return PersonDTO.builder()
                .id(person.getId())
                .name(person.getName())
                .gender(person.getGender())
                .age(person.getAge())
                .build();
    }

    public static List<PersonDTO> toPersonDTO(List<Person> personList) {
        return personList.stream()
                .map(PersonMapper::toPersonDTO)
                .toList();
    }

    public static Person toPerson(PersonDTO personDTO) {
        return Person.builder()
                .id(personDTO.getId())
                .name(personDTO.getName())
                .gender(personDTO.getGender())
                .age(personDTO.getAge())
                .build();
    }
}
