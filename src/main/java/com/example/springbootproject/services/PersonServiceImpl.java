package com.example.springbootproject.services;

import com.example.springbootproject.dto.PersonDTO;
import com.example.springbootproject.entities.Person;
import com.example.springbootproject.exceptions.PersonNotFoundException;
import com.example.springbootproject.mappers.PersonMapper;
import com.example.springbootproject.repositories.PersonRepo;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements BasePersonService, QueryPersonService, MutationPersonService {
    private final PersonMapper personMapper;
    private final PersonRepo repo;

    private static final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Override
    public PersonDTO create(PersonDTO personDTO) {
        logger.info("Creating new person with name: {}", personDTO.getName());
        Person person = personMapper.toPerson(personDTO);
        Person savedPerson = repo.save(person);
        logger.debug("Created person with ID: {}", savedPerson.getId());
        return personMapper.toPersonDTO(savedPerson);
    }

    @Override
    public PersonDTO getById(Long id) {
        logger.info("Fetching person by ID: {}", id);
        return repo.findById(id)
                .map(person -> {
                    logger.debug("Found person with ID: {}", id);
                    return personMapper.toPersonDTO(person);
                })
                .orElseThrow(() -> {
                    logger.error("Person not found with ID: {}", id);
                    return new PersonNotFoundException(id);
                });
    }

    @Override
    public List<PersonDTO> getByName(String name) {
        logger.info("Searching persons by name: '{}'", name);
        List<Person> persons = repo.findByName(name);
        logger.debug("Found {} persons with name '{}'", persons.size(), name);
        return personMapper.toPersonDTO(persons);
    }

    @Override
    public List<PersonDTO> getByAgeInRange(int minAge, int maxAge) {
        logger.info("Searching persons by age range: {} - {}", minAge, maxAge);
        List<Person> persons = repo.findByAgeBetween(minAge, maxAge);
        logger.debug("Found {} persons in age range {} - {}", persons.size(), minAge, maxAge);
        return personMapper.toPersonDTO(persons);
    }

    @Override
    public List<PersonDTO> getAll() {
        logger.info("Fetching all persons");
        List<Person> persons = repo.findAll();
        logger.debug("Found {} persons in total", persons.size());
        return personMapper.toPersonDTO(persons);
    }

    @Override
    public void remove(Long id) {
        logger.info("Attempting to delete person with ID: {}", id);
        repo.findById(id)
            .ifPresentOrElse(
                person -> {
                    repo.delete(person);
                    logger.debug("Deleted person with ID: {}, name: '{}'",
                            id, person.getName());
                },
                () -> logger.warn("Person with ID: {} does not exist", id)
        );
    }

    @Override
    public PersonDTO increaseAgeByOne(Long id) {
        logger.info("Increasing age for person with ID: {}", id);
        return repo.findById(id)
                .map(person -> {
                    person.setAge(person.getAge() + 1);
                    Person updated = repo.save(person);
                    logger.debug("Increased age for person ID: {}, new age: {}",
                            id, updated.getAge());
                    return updated;
                })
                .map(personMapper::toPersonDTO)
                .orElseThrow(() -> {
                    logger.error("Failed to increase age - person not found with ID: {}", id);
                    return new PersonNotFoundException(id);
                });
    }

    @Override
    public PersonDTO changeName(Long id, String newName) {
        logger.info("Attempting to change name for person ID: {} to '{}'", id, newName);
        return repo.findById(id)
                .map(person -> {
                    String oldName = person.getName();
                    person.setName(newName);
                    Person updated = repo.save(person);
                    logger.debug("Changed name for person ID: {} from '{}' to '{}'",
                            id, oldName, newName);
                    return updated;
                })
                .map(personMapper::toPersonDTO)
                .orElseThrow(() -> {
                    logger.error("Failed to change name - person not found with ID: {}", id);
                    return new PersonNotFoundException(id);
                });
    }

    @Override
    public PersonDTO changeGender(Long id, String newGender) {
        logger.info("Attempting to change gender for person ID: {} to '{}'", id, newGender);
        return repo.findById(id)
                .map(person -> {
                    String oldGender = person.getGender();
                    person.setGender(newGender);
                    Person updated = repo.save(person);
                    logger.debug("Changed gender for person ID: {} from '{}' to '{}'",
                            id, oldGender, newGender);
                    return updated;
                })
                .map(personMapper::toPersonDTO)
                .orElseThrow(() -> {
                    logger.error("Failed to change gender - person not found with ID: {}", id);
                    return new PersonNotFoundException(id);
                });
    }
}
