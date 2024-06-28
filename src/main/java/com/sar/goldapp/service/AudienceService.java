package com.sar.goldapp.service;

import com.sar.goldapp.model.Audience;
import com.sar.goldapp.repository.AudienceRepository;
import com.sar.goldapp.service.dto.AudienceDTO;
import com.sar.goldapp.service.mapper.AudienceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AudienceService {

    private final Logger log = LoggerFactory.getLogger(AudienceService.class);
    private final AudienceRepository audienceRepository;
    private final AudienceMapper audienceMapper;

    public AudienceService(AudienceRepository audienceRepository,
                           AudienceMapper audienceMapper) {
        this.audienceRepository = audienceRepository;
        this.audienceMapper = audienceMapper;
    }


    public AudienceDTO save(AudienceDTO dto) {
        Audience audience = audienceMapper.toEntity(dto);
        audience = audienceRepository.save(audience);
        return audienceMapper.toDto(audience);
    }

    public AudienceDTO update(AudienceDTO dto) {
        Audience audience = audienceMapper.toEntity(dto);
        audience = audienceRepository.save(audience);
        return audienceMapper.toDto(audience);
    }

    public void delete(AudienceDTO dto) {
        Audience audience = audienceMapper.toEntity(dto);
        audienceRepository.delete(audience);
    }

    public void delete(long id) {
        audienceRepository.deleteById(id);
    }

    public void deleteInBatch(List<AudienceDTO> dtos) {
        List<Audience> audiences = audienceMapper.toEntity(dtos);
        audienceRepository.deleteAll(audiences);
    }

    public AudienceDTO find(long id) {
        Audience audience = audienceRepository.getById(id);
        return audienceMapper.toDto(audience);
    }

    public List<AudienceDTO> findAll() {
        List<Audience> audiences = audienceRepository.findAll();
        return audienceMapper.toDto(audiences);
    }

    public void saveAll(List<AudienceDTO> audienceDTOList) {
        audienceRepository.saveAll(audienceMapper.toEntity(audienceDTOList));
    }

    public AudienceDTO getByPersonId(long personId) {
        return audienceMapper.toDto(audienceRepository.getByPersonId(personId));
    }
}
