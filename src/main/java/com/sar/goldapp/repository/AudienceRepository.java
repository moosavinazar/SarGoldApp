package com.sar.goldapp.repository;

import com.sar.goldapp.model.Audience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudienceRepository extends JpaRepository<Audience, Long> {

    Audience getByPersonId(long personId);

}
