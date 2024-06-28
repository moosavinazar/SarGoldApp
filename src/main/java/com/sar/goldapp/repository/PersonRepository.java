package com.sar.goldapp.repository;

import com.sar.goldapp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    boolean existsBypCode(String pCode);

    Person getBypCode(String pCode);

    boolean existsByCellPhone(String cellPhone);

}
