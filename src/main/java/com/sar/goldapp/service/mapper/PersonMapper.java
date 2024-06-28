package com.sar.goldapp.service.mapper;

import com.sar.goldapp.model.Person;
import com.sar.goldapp.service.dto.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring", uses = {CityMapper.class})
public interface PersonMapper extends EntityMapper<PersonDTO, Person> {

    @Mapping(source = "city.id", target = "cityId")
    PersonDTO toDto(Person person);

    @Mapping(source = "cityId", target = "city")
    Person toEntity(PersonDTO personDTO);

    default Person fromId(Long id) {
        if (id == null) {
            return null;
        }
        Person person = new Person();
        person.setId(id);
        return person;
    }

}
