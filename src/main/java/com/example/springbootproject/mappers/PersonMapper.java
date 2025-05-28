package com.example.springbootproject.mappers;

import com.example.springbootproject.dto.PersonDTO;
import com.example.springbootproject.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper {
    PersonDTO toPersonDTO(Person person);
    List<PersonDTO> toPersonDTO(List<Person> personList);
    Person toPerson(PersonDTO personDTO);
}
