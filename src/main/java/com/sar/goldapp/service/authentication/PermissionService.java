package com.sar.goldapp.service.authentication;

import com.sar.goldapp.model.authentication.Permission;
import com.sar.goldapp.repository.authentication.PermissionRepository;
import com.sar.goldapp.service.dto.authentication.PermissionDTO;
import com.sar.goldapp.service.mapper.authentication.PermissionMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionService {

    private final PermissionRepository permissionRepository;

    private final PermissionMapper permissionMapper;

    public PermissionService(PermissionRepository permissionRepository, PermissionMapper permissionMapper) {
        this.permissionRepository = permissionRepository;
        this.permissionMapper = permissionMapper;
    }


    
    public PermissionDTO save(PermissionDTO dto) {
        Permission permission = permissionMapper.toEntity(dto);
        permission = permissionRepository.save(permission);
        return permissionMapper.toDto(permission);
    }

    
    public PermissionDTO update(PermissionDTO dto) {
        Permission permission = permissionMapper.toEntity(dto);
        permission = permissionRepository.save(permission);
        return permissionMapper.toDto(permission);
    }

    
    public void delete(PermissionDTO dto) {
        Permission permission = permissionMapper.toEntity(dto);
        permissionRepository.delete(permission);
    }

    
    public void delete(long id) {
        permissionRepository.deleteById(id);
    }

    
    public void deleteInBatch(List<PermissionDTO> dtos) {
        List<Permission> permissions = permissionMapper.toEntity(dtos);
        permissionRepository.deleteAll(permissions);
    }

    
    public PermissionDTO find(long id) {
        Permission permission = permissionRepository.getById(id);
        return permissionMapper.toDto(permission);
    }

    
    public List<PermissionDTO> findAll() {
        List<Permission> permissions = permissionRepository.findAll();
        return permissionMapper.toDto(permissions);
    }

}
