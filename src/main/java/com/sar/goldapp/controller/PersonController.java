package com.sar.goldapp.controller;

import com.sar.goldapp.service.PersonService;
import com.sar.goldapp.service.dto.PersonDTO;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public PersonDTO save(PersonDTO dto) {
        return personService.save(dto);
    }

    public PersonDTO update(PersonDTO dto) {
        return personService.update(dto);
    }

    public void delete(PersonDTO dto) {
        personService.delete(dto);
    }

    public void delete(long id) {
        personService.delete(id);
    }

    public void deleteInBatch(List<PersonDTO> dtos) {
        personService.deleteInBatch(dtos);
    }

    public PersonDTO find(long id) {
        return personService.find(id);
    }

    public List<PersonDTO> findAll() {
        return personService.findAll();
    }

    public boolean isExistCellPhone(String cellPhone) {
        return personService.isExistCellPhone(cellPhone);
    }

    public PersonDTO getBypCod(String cod) {
        return personService.getBypCod(cod);
    }
}
