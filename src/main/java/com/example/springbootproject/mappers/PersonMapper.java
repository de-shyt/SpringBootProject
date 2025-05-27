package com.example.springbootproject.mappers;

import com.example.springbootproject.dto.PersonDTO;
import com.example.springbootproject.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonMapper {
    PersonDTO toPersonDTO(Person person);
    List<PersonDTO> toPersonDTO(List<Person> personList);
    Person toPerson(PersonDTO personDTO);
}
