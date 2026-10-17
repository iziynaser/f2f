package ir.verjik.service;

import ir.verjik.dto.PersonDTO;
import ir.verjik.entity.PersonEntity;
import ir.verjik.mapper.PersonMapper;
import ir.verjik.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonEntity save(PersonEntity p) {
        return personRepository.save(p);
    }

    public PersonServiceImpl(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Override
    public Optional<PersonEntity> findEntityById(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public PersonDTO save(PersonDTO personDTO) {
        PersonEntity person = personMapper.toEntity(personDTO);
        person = personRepository.save(person);
        return personMapper.toDTO(person);
    }

    @Override
    public Optional<PersonDTO> findById(Long id) {
        return personRepository.findById(id)
                .map(personMapper::toDTO);
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
