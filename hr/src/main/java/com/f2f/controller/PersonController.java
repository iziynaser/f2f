package com.f2f.controller;


import com.f2f.dto.PersonDTO;
import com.f2f.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController("PersonController")
@RequestMapping("/persons")
//@CrossOrigin("*")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/list")
    public List<PersonDTO> getPersons(){
       return personService.findAll();
    }

}

/*

//    @GetMapping("/person/{id}")
//    public PersonDTO findById(@PathVariable(value = "id") Long id)throws F2fNotFoundException {
//        Optional<PersonEntity> b= service.findById(id);
//        if(!b.isPresent())
//            throw new F2fNotFoundException("f2f.not.found",id);
//        PersonEntity pfbi = b.get();
//        return pfbi;
//    }
//
//    @PostMapping("/person")
//    public PersonDTO save(@RequestBody PersonDTO p)
//    {
//        PersonDTO b = service.save(p);
//        return b;
//    }

//    @DeleteMapping("person/{id}")
//    public Map<String,Boolean> deleteById(@PathVariable Long id)throws F2fNotFoundException {
//        Optional<Person> b= service.findById(id);
//        if(!b.isPresent())
//            throw new F2fNotFoundException("f2f.not.found",id);
//
//        Person dpf = b.get();
//
//        //service.delete(dpf,dpf.getId());
//        HashMap response = new HashMap();
//        response.put("deleted",true);
//        return response;
//    }


@RestController
@RequestMapping("/persons")
public class PersonController {


    @PostMapping
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO personDTO) {
        PersonDTO savedPerson = personService.save(personDTO);
        return ResponseEntity.ok(savedPerson);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getPerson(@PathVariable Long id) {
        PersonDTO personDTO = personService.findById(id);
        if(personDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(personDTO);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

 */
