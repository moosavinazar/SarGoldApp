package com.sar.goldapp.service;

import com.sar.goldapp.model.Bank;
import com.sar.goldapp.repository.BankRepository;
import com.sar.goldapp.service.dto.BankDTO;
import com.sar.goldapp.service.mapper.BankMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BankService {

    private final BankRepository bankRepository;

    private final BankMapper bankMapper;

    public BankService(BankRepository bankRepository, BankMapper bankMapper) {
        this.bankRepository = bankRepository;
        this.bankMapper = bankMapper;
    }


    public BankDTO save(BankDTO dto) {
        Bank bank = bankMapper.toEntity(dto);
        bank = bankRepository.save(bank);
        return bankMapper.toDto(bank);
    }

    public BankDTO update(BankDTO dto) {
        Bank bank = bankMapper.toEntity(dto);
        bank = bankRepository.save(bank);
        return bankMapper.toDto(bank);
    }

    public void delete(BankDTO dto) {
        Bank bank = bankMapper.toEntity(dto);
        bankRepository.delete(bank);
    }

    public void delete(long id) {
        bankRepository.deleteById(id);
    }

    public void deleteInBatch(List<BankDTO> dtos) {
        List<Bank> banks = bankMapper.toEntity(dtos);
        bankRepository.deleteAll(banks);
    }

    public BankDTO find(long id) {
        Bank bank = bankRepository.getById(id);
        return bankMapper.toDto(bank);
    }

    public List<BankDTO> findAll() {
        List<Bank> banks = bankRepository.findAll();
        return bankMapper.toDto(banks);
    }

    public boolean isExist(String pCode) {
        return bankRepository.existsBypCode(pCode);
    }
}
