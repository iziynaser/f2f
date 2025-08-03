package com.f2f.service;

import com.f2f.dto.PersonDTO;
import com.f2f.entity.PersonEntity;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    public PersonDTO save(PersonDTO personDTO);
    public Optional<PersonDTO> findById(Long id);
    public List<PersonDTO> findAll();
    public void deleteById(Long id);
    public Optional<PersonEntity> findEntityById(Long id);
}
