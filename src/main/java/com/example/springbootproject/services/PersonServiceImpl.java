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
public class PersonServiceImpl implements BasePersonService, QueryPersonService, MutationPersonService {
    private final PersonRepo repo;

    @Override
    public PersonDTO create(PersonDTO personDTO) {
        Person person = PersonMapper.toPerson(personDTO);
        Person savedPerson = repo.save(person);
        return PersonMapper.toPersonDTO(savedPerson);
    }

    @Override
    public PersonDTO getById(Long id) {
        return repo.findById(id)
                .map(PersonMapper::toPersonDTO)
                .orElse(null);
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
    public void remove(Long id) {
        repo.findById(id).ifPresent(repo::delete);
    }

    @Override
    public PersonDTO increaseAgeByOne(Long id) {
        return repo.findById(id)
                .map(person -> {
                    person.setAge(person.getAge() + 1);
                    return repo.save(person);
                })
                .map(PersonMapper::toPersonDTO)
                .orElse(null);
    }

    @Override
    public PersonDTO changeName(Long id, String newName) {
        return repo.findById(id)
                .map(person -> {
                    person.setName(newName);
                    return repo.save(person);
                })
                .map(PersonMapper::toPersonDTO)
                .orElse(null);
    }

    @Override
    public PersonDTO changeGender(Long id, String newGender) {
        return repo.findById(id)
                .map(person -> {
                    person.setGender(newGender);
                    return repo.save(person);
                })
                .map(PersonMapper::toPersonDTO)
                .orElse(null);
    }
}
