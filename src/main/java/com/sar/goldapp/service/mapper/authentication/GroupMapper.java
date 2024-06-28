package com.sar.goldapp.service.mapper.authentication;

import com.sar.goldapp.model.authentication.Group;
import com.sar.goldapp.service.dto.authentication.GroupDTO;
import com.sar.goldapp.service.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring", uses = {})
public interface GroupMapper extends EntityMapper<GroupDTO, Group> {

    default Group fromId(Long id) {
        if (id == null) {
            return null;
        } else {
            Group group = new Group();
            group.setId(id);
            return group;
        }
    }

}
