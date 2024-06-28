package com.sar.goldapp.service.mapper;

import com.sar.goldapp.model.Laboratory;
import com.sar.goldapp.service.dto.LaboratoryDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring", uses = {})
public interface LaboratoryMapper extends EntityMapper<LaboratoryDTO, Laboratory> {

    default Laboratory fromId(Long id) {
        if (id == null) {
            return null;
        }
        Laboratory laboratory = new Laboratory();
        laboratory.setId(id);
        return laboratory;
    }

}
