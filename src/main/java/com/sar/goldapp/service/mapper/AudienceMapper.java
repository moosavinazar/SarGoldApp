package com.sar.goldapp.service.mapper;

import com.sar.goldapp.model.Audience;
import com.sar.goldapp.service.dto.AudienceDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AudienceMapper {

    private final PersonMapper personMapper;

    private final BankMapper bankMapper;

    private final LaboratoryMapper laboratoryMapper;
    
    public AudienceMapper(PersonMapper personMapper, BankMapper bankMapper,
                          LaboratoryMapper laboratoryMapper) {
        this.personMapper = personMapper;
        this.bankMapper = bankMapper;
        this.laboratoryMapper = laboratoryMapper;
    }

    public AudienceDTO toDto(Audience audience) {

        AudienceDTO audienceDTO;
        if (audience != null) {
            audienceDTO = new AudienceDTO(audience);
            audienceDTO.setBank(bankMapper.toDto(audience.getBank()));
            audienceDTO.setPerson(personMapper.toDto(audience.getPerson()));
            audienceDTO.setLaboratory(laboratoryMapper.toDto(audience.getLaboratory()));
            if (audienceDTO.getBank() != null) {
                audienceDTO.setName(audienceDTO.getBank().getName());
                audienceDTO.setBalanceR(0);
            } else if (audienceDTO.getPerson() != null) {
                audienceDTO.setName(audienceDTO.getPerson().getName());
                //audienceDTO.setBalanceR(reportRepository.getUserBalance(audienceDTO.getPerson().getpCode()).getBalance_r());
            } else if (audienceDTO.getLaboratory() != null) {
                audienceDTO.setName(audienceDTO.getLaboratory().getName());
                audienceDTO.setBalanceR(0);
            }
            audienceDTO.setLabel(audienceDTO.getName(), audienceDTO.getBalanceR());
        } else {
            audienceDTO = new AudienceDTO();
        }
        return audienceDTO;
    }

    public List<AudienceDTO> toDto(List<Audience> audiences) {
        return audiences.stream()
                .filter(Objects::nonNull)
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Audience toEntity(AudienceDTO audienceDTO) {
        if (audienceDTO == null) {
            return null;
        }
        Audience audience = new Audience(audienceDTO.getId());
        audience.setBank(bankMapper.toEntity(audienceDTO.getBank()));
        audience.setPerson(personMapper.toEntity(audienceDTO.getPerson()));
        audience.setLaboratory(laboratoryMapper.toEntity(audienceDTO.getLaboratory()));
        return audience;
    }

    public List<Audience> toEntity(List<AudienceDTO> audienceDTOS) {
        return audienceDTOS.stream()
                .filter(Objects::nonNull)
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public Audience fromId(Long id) {
        if (id == null) {
            return null;
        } else {
            Audience audience = new Audience();
            audience.setId(id);
            return audience;
        }
    }

}
