package com.sar.goldapp.controller.authentication;

import com.sar.goldapp.service.authentication.GroupService;
import com.sar.goldapp.service.dto.authentication.GroupDTO;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    public GroupDTO save(GroupDTO dto) {
        return groupService.save(dto);
    }

    public GroupDTO update(GroupDTO dto) {
        return groupService.update(dto);
    }

    public void delete(GroupDTO dto) {
        groupService.delete(dto);
    }

    public void delete(long id) {
        groupService.delete(id);
    }

    public void deleteInBatch(List<GroupDTO> dtos) {
        groupService.deleteInBatch(dtos);
    }

    public GroupDTO find(long id) {
        return groupService.find(id);
    }

    public List<GroupDTO> findAll() {
        List<GroupDTO> group = groupService.findAll();
        return group;
    }

}
