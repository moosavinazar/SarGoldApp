package com.sar.goldapp.service.authentication;

import com.sar.goldapp.model.authentication.Group;
import com.sar.goldapp.repository.authentication.GroupRepository;
import com.sar.goldapp.service.dto.authentication.GroupDTO;
import com.sar.goldapp.service.mapper.authentication.GroupMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GroupService {

    private final GroupRepository groupRepository;

    private final GroupMapper groupMapper;

    public GroupService(GroupRepository groupRepository, GroupMapper groupMapper) {
        this.groupRepository = groupRepository;
        this.groupMapper = groupMapper;
    }


    public GroupDTO save(GroupDTO dto) {
        Group group = groupMapper.toEntity(dto);
        group = groupRepository.save(group);
        return groupMapper.toDto(group);
    }

    public GroupDTO update(GroupDTO dto) {
        Group group = groupMapper.toEntity(dto);
        group = groupRepository.save(group);
        return groupMapper.toDto(group);
    }

    public void delete(GroupDTO dto) {
        Group group = groupMapper.toEntity(dto);
        groupRepository.delete(group);
    }

    public void delete(long id) {
        groupRepository.deleteById(id);
    }

    public void deleteInBatch(List<GroupDTO> dtos) {
        List<Group> groups = groupMapper.toEntity(dtos);
        groupRepository.deleteAll(groups);
    }

    public GroupDTO find(long id) {
        Group group = groupRepository.getById(id);
        return groupMapper.toDto(group);
    }

    public List<GroupDTO> findAll() {
        List<Group> groups = groupRepository.findAll();
        return groupMapper.toDto(groups);
    }

}
