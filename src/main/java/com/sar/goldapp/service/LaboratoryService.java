package com.sar.goldapp.service;

import com.sar.goldapp.model.Laboratory;
import com.sar.goldapp.repository.LaboratoryRepository;
import com.sar.goldapp.service.dto.LaboratoryDTO;
import com.sar.goldapp.service.mapper.LaboratoryMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LaboratoryService {

    private final LaboratoryRepository laboratoryRepository;

    private final LaboratoryMapper laboratoryMapper;

    public LaboratoryService(LaboratoryRepository laboratoryRepository, LaboratoryMapper laboratoryMapper) {
        this.laboratoryRepository = laboratoryRepository;
        this.laboratoryMapper = laboratoryMapper;
    }


    public LaboratoryDTO save(LaboratoryDTO dto) {
        Laboratory laboratory = laboratoryMapper.toEntity(dto);
        laboratory = laboratoryRepository.save(laboratory);
        return laboratoryMapper.toDto(laboratory);
    }

    public LaboratoryDTO update(LaboratoryDTO dto) {
        Laboratory laboratory = laboratoryMapper.toEntity(dto);
        laboratory = laboratoryRepository.save(laboratory);
        return laboratoryMapper.toDto(laboratory);
    }

    public void delete(LaboratoryDTO dto) {
        Laboratory laboratory = laboratoryMapper.toEntity(dto);
        laboratoryRepository.delete(laboratory);
    }

    public void delete(long id) {
        laboratoryRepository.deleteById(id);
    }

    public void deleteInBatch(List<LaboratoryDTO> dtos) {
        List<Laboratory> laboratories = laboratoryMapper.toEntity(dtos);
        laboratoryRepository.deleteAll(laboratories);
    }

    public LaboratoryDTO find(long id) {
        Laboratory laboratory = laboratoryRepository.getById(id);
        return laboratoryMapper.toDto(laboratory);
    }

    public List<LaboratoryDTO> findAll() {
        List<Laboratory> laboratories = laboratoryRepository.findAll();
        return laboratoryMapper.toDto(laboratories);
    }

    public boolean isExist(String pCode) {
        return laboratoryRepository.existsBypCode(pCode);
    }

}
