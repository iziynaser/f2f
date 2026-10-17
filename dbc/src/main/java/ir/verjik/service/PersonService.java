package ir.verjik.service;

import ir.verjik.dto.PersonDTO;
import ir.verjik.entity.PersonEntity;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    public PersonDTO save(PersonDTO personDTO);
    public Optional<PersonDTO> findById(Long id);
    public List<PersonDTO> findAll();
    public void deleteById(Long id);
    public Optional<PersonEntity> findEntityById(Long id);
}
