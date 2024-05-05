package com.f2f.controller.hr;

import com.f2f.entity.common.Person;
import com.f2f.exceptions.F2fNotFoundException;
import com.f2f.service.hr.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController("PersonController")
@RequestMapping("/f2f/")
@CrossOrigin("*")
public class PersonController {

    @Autowired
    PersonService service;

    @GetMapping("/person")
    public List<Person> getPersons(){
        List<Person> rt = service.findAll();
        return rt;
    }

    @GetMapping("/person/{id}")
    public Person findById(@PathVariable(value = "id") Long id)throws F2fNotFoundException {
        Optional<Person> b= service.findById(id);
        if(!b.isPresent())
            throw new F2fNotFoundException("id:"+id);
        Person pfbi = b.get();
        return pfbi;
    }

    @PostMapping("/person")
    public Person save(@RequestBody Person p)
    {
        Person b = service.save(p);
        return b;
    }

    @DeleteMapping("person/{id}")
    public Map<String,Boolean> deleteById(@PathVariable Long id)throws F2fNotFoundException {
        Optional<Person> b= service.findById(id);
        if(!b.isPresent())
            throw new F2fNotFoundException("id:"+id);

        Person dpf = b.get();

        //service.delete(dpf,dpf.getId());
        HashMap response = new HashMap();
        response.put("deleted",true);
        return response;
    }
}
