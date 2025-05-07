package com.example.springbootproject.services;

import com.example.springbootproject.dto.PersonDTO;
import com.example.springbootproject.entities.Person;
import com.example.springbootproject.mappers.PersonMapper;
import com.example.springbootproject.repositories.PersonRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements BasePersonService, GetPersonService, ModifyPersonService {
    private final PersonRepo repo;

    @Override
    public PersonDTO create(PersonDTO personDTO) {
        Person person = PersonMapper.toPerson(personDTO);
        Person savedPerson = repo.save(person);
        return PersonMapper.toPersonDTO(savedPerson);
    }

    @Override
    public PersonDTO getById(Long id) {
        Person person = repo.findById(id).orElse(null);
        if (person == null) return null;
        return PersonMapper.toPersonDTO(person);
    }

    @Override
    public List<PersonDTO> getByName(String name) {
        return PersonMapper.toPersonDTO(repo.findByName(name));
    }

    @Override
    public List<PersonDTO> getByAgeInRange(int minAge, int maxAge) {
        return PersonMapper.toPersonDTO(repo.findByAgeBetween(minAge, maxAge));
    }

    @Override
    public List<PersonDTO> getAll() {
        return PersonMapper.toPersonDTO(repo.findAll());
    }

    @Override
    public PersonDTO remove(Long id) {
        Person person = repo.findById(id).orElse(null);
        if (person == null) return null;
        repo.delete(person);
        return PersonMapper.toPersonDTO(person);
    }

    @Override
    public PersonDTO increaseAgeByOne(Long id) {
        Person person = repo.findById(id).orElse(null);
        if (person == null) return null;
        person.setAge(person.getAge() + 1);
        Person updatedPerson = repo.save(person);
        return PersonMapper.toPersonDTO(updatedPerson);
    }

    @Override
    public PersonDTO changeName(Long id, String newName) {
        Person person = repo.findById(id).orElse(null);
        if (person == null) return null;
        person.setName(newName);
        Person updatedPerson = repo.save(person);
        return PersonMapper.toPersonDTO(updatedPerson);
    }

    @Override
    public PersonDTO changeGender(Long id, String newGender) {
        Person person = repo.findById(id).orElse(null);
        if (person == null) return null;
        person.setGender(newGender);
        Person updatedPerson = repo.save(person);
        return PersonMapper.toPersonDTO(updatedPerson);
    }
}
