package com.sar.goldapp.service.mapper.authentication;

import com.sar.goldapp.model.authentication.User;
import com.sar.goldapp.service.dto.authentication.UserDTO;
import com.sar.goldapp.service.mapper.EntityMapper;
import com.sar.goldapp.service.mapper.PersonMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring", uses = {PersonMapper.class})
public interface UserMapper extends EntityMapper<UserDTO, User> {

    @Mapping(target = "password", ignore = true)
    UserDTO toDto(User user);

    default User fromId(Long id) {
        if (id == null) {
            return null;
        } else {
            User user = new User();
            user.setId(id);
            return user;
        }
    }

}
