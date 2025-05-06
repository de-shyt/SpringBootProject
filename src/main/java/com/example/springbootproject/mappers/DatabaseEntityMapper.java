package com.example.springbootproject.mappers;

import com.example.springbootproject.dto.DatabaseEntryDTO;
import com.example.springbootproject.entities.Person;

public class DatabaseEntityMapper {
    public static DatabaseEntryDTO toDatabaseEntryDTO(Long id, Person person) {
        return new DatabaseEntryDTO(id, PersonMapper.toPersonDTO(person));
    }
}
