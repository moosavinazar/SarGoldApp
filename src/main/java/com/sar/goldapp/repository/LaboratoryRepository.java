package com.sar.goldapp.repository;

import com.sar.goldapp.model.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoryRepository extends JpaRepository<Laboratory, Long> {

    boolean existsBypCode(String pCode);

}
