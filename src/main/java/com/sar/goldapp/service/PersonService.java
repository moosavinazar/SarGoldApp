package com.sar.goldapp.service;

import com.sar.goldapp.model.Person;
import com.sar.goldapp.repository.CityRepository;
import com.sar.goldapp.repository.PersonRepository;
import com.sar.goldapp.service.dto.PersonDTO;
import com.sar.goldapp.service.mapper.PersonMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    private final CityRepository cityRepository;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper,
                         CityRepository cityRepository) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
        this.cityRepository = cityRepository;
    }

    public PersonDTO save(PersonDTO dto) {
        Person person = personMapper.toEntity(dto);
        person = personRepository.save(person);
        return personMapper.toDto(person);
    }

    public PersonDTO update(PersonDTO dto) {
        Person person = personRepository.getById(dto.getId());
        person.setName(dto.getName());
        person.setDateOfBirth(dto.getDateOfBirth());
        person.setEmail(dto.getEmail());
        person.setCellPhone(dto.getCellPhone());
        person.setPhoneNumberOne(dto.getPhoneNumberOne());
        person.setPhoneNumberTwo(dto.getPhoneNumberTwo());
        person.setPhoneNumberThree(dto.getPhoneNumberThree());
        person.setCity(cityRepository.findById(dto.getCityId()).get());
        person.setAddress(dto.getAddress());
        person.setDescription(dto.getDescription());
        person.setGender(dto.getGender());
        person = personRepository.save(person);
        return personMapper.toDto(person);
    }

    public void delete(PersonDTO dto) {
        Person person = personMapper.toEntity(dto);
        personRepository.delete(person);
    }

    public void delete(long id) {
        personRepository.deleteById(id);
    }

    public void deleteInBatch(List<PersonDTO> dtos) {
        List<Person> personList = personMapper.toEntity(dtos);
        personRepository.deleteAll(personList);
    }

    public PersonDTO find(long id) {
        Person person = personRepository.getById(id);
        return personMapper.toDto(person);
    }

    public List<PersonDTO> findAll() {
        List<Person> personList = personRepository.findAll();
        return personMapper.toDto(personList);
    }

    public boolean isExist(String pCode) {
        return personRepository.existsBypCode(pCode);
    }

    public boolean isExistCellPhone(String cellPhone) {
        return personRepository.existsByCellPhone(cellPhone);
    }

    public PersonDTO getBypCod(String cod) {
        return personMapper.toDto(personRepository.getBypCode(cod));
    }
}
