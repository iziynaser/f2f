package com.f2f.service;

import com.f2f.dto.PersonDTO;
import java.util.List;

public interface PersonService {
    public PersonDTO save(PersonDTO personDTO);
    public PersonDTO findById(Long id);
    public List<PersonDTO> findAll();
    public void deleteById(Long id);
}
