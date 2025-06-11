package com.f2f.service;

import com.f2f.dto.PersonDTO;
import java.util.List;

public interface PersonService {
    PersonDTO save(PersonDTO personDTO);
    PersonDTO findById(Long id);
    List<PersonDTO> findAll();
    void deleteById(Long id);
}
