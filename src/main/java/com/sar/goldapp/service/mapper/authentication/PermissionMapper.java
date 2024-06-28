package com.sar.goldapp.service.mapper.authentication;

import com.sar.goldapp.model.authentication.Permission;
import com.sar.goldapp.service.dto.authentication.PermissionDTO;
import com.sar.goldapp.service.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring", uses = {})
public interface PermissionMapper extends EntityMapper<PermissionDTO, Permission> {
}
