package com.sar.goldapp.controller.authentication;

import com.sar.goldapp.controller.PersonController;
import com.sar.goldapp.service.authentication.UserService;
import com.sar.goldapp.service.dto.PersonDTO;
import com.sar.goldapp.service.dto.authentication.CreateUserDTO;
import com.sar.goldapp.service.dto.authentication.GroupDTO;
import com.sar.goldapp.service.dto.authentication.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {

    private final UserService userService;
    private final GroupController groupController;
    private final PersonController personController;

    public UserController(UserService userService, GroupController groupController, PersonController personController) {
        this.userService = userService;
        this.groupController = groupController;
        this.personController = personController;
    }
    public UserDTO findByUsername(String name) {
        return userService.findByUsername(name);
    }
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @Transactional
    public UserDTO create(CreateUserDTO dto) {
        UserDTO user = new UserDTO();
        PersonDTO person = new PersonDTO(dto.getName(), dto.getDateOfBirth(), dto.getGender(), dto.getEmail(),
                dto.getCellPhone(), dto.getPhoneNumberOne(), dto.getPhoneNumberTwo(), dto.getPhoneNumberThree(),
                dto.getAddress(), dto.getCityId(), dto.getDescription(), dto.isVip());
        Set<GroupDTO> groups = new HashSet<>();
        for (Long groupId: dto.getGroupIds()
        ) {
            groups.add(groupController.find(groupId));
        }
        user.setGroups(groups);
        user.setUsername(dto.getCellPhone());
        person = personController.save(person);
        user.setPerson(person);
        return userService.createUser(user, dto.getPassword());
    }

}
