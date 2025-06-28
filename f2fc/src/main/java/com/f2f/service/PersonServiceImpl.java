package com.f2f.service;

import com.f2f.dao.PersonDao;
import com.f2f.dto.PersonDTO;
import com.f2f.entity.PersonEntity;
import com.f2f.mapper.PersonMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao personRepository;
    private final PersonMapper personMapper;

    public PersonEntity save(PersonEntity p) {
        return personRepository.save(p);
    }

    public PersonServiceImpl(PersonDao personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Override
    public PersonDTO save(PersonDTO personDTO) {
        PersonEntity person = personMapper.toEntity(personDTO);
        person = personRepository.save(person);
        return personMapper.toDTO(person);
    }

    @Override
    public PersonDTO findById(Long id) {
        return personRepository.findById(id)
                .map(personMapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<PersonDTO> findAll() {
        return personRepository.findAll().stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}
