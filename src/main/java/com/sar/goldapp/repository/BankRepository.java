package com.sar.goldapp.repository;

import com.sar.goldapp.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

    boolean existsBypCode(String pCode);

}
