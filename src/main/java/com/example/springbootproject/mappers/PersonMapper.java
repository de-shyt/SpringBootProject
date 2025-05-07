package com.example.springbootproject.mappers;

import com.example.springbootproject.dto.PersonDTO;
import com.example.springbootproject.entities.Person;

import java.util.List;

public class PersonMapper {
    public static PersonDTO toPersonDTO(Person person) {
        return new PersonDTO(
                person.getId(),
                person.getName(),
                person.getGender(),
                person.getAge()
        );
    }

    public static List<PersonDTO> toPersonDTO(List<Person> personList) {
        return personList.stream().map(PersonMapper::toPersonDTO).toList();
    }

    public static Person toPerson(PersonDTO personDTO) {
        return new Person(
                personDTO.getId(),
                personDTO.getName(),
                personDTO.getGender(),
                personDTO.getAge()
        );
    }
}
