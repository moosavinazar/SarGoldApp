package com.sar.goldapp.service.authentication;

import com.sar.goldapp.model.Audience;
import com.sar.goldapp.model.authentication.User;
import com.sar.goldapp.repository.authentication.UserRepository;
import com.sar.goldapp.service.*;
import com.sar.goldapp.service.dto.AudienceDTO;
import com.sar.goldapp.service.dto.BankDTO;
import com.sar.goldapp.service.dto.LaboratoryDTO;
import com.sar.goldapp.service.dto.PersonDTO;
import com.sar.goldapp.service.dto.authentication.UserDTO;
import com.sar.goldapp.service.mapper.authentication.UserMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final BCryptPasswordEncoder passwordEncoder;

    private final PersonService personService;

    private final BankService bankService;

    private final LaboratoryService laboratoryService;

    private final AudienceService audienceService;

    public UserService(UserRepository userRepository,
                       UserMapper userMapper,
                       PersonService personService,
                       BankService bankService,
                       LaboratoryService laboratoryService,
                       AudienceService audienceService
                       ) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.personService = personService;
        this.bankService = bankService;
        this.laboratoryService = laboratoryService;
        this.audienceService = audienceService;
    }

    public UserDTO save(UserDTO dto) {
        User user = userMapper.toEntity(dto);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    public UserDTO createUser(UserDTO dto, String password) {
        User user = userMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(password));
        Audience audience = new Audience(user.getPerson());
        user.getPerson().setAudience(audience);
        user.setEnable(true);
        user.setCredential(true);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    public UserDTO update(UserDTO dto) {
        User u = userRepository.getById(dto.getId());
        User user = userMapper.toEntity(dto);
        user.setPassword(u.getPassword());
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    public void delete(UserDTO dto) {
        User user = userMapper.toEntity(dto);
        userRepository.delete(user);
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }

    public void deleteInBatch(List<UserDTO> dtos) {
        List<User> users = userMapper.toEntity(dtos);
        userRepository.deleteAllInBatch(users);
    }

    public UserDTO find(long id) {
        User user = userRepository.findById(id).get();
        return userMapper.toDto(user);
    }

    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        return userMapper.toDto(users);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s);
    }

    public UserDTO findByUsername(String username) {
        return userMapper.toDto(userRepository.findByUsername(username));
    }

    public UserDTO findByPersonId(long personId) {
        return userMapper.toDto(userRepository.findByPersonId(personId));
    }

    public List<UserDTO> findAllByPriceGroupId(long priceGroupId) {
        return userMapper.toDto(userRepository.findAllByPriceGroupId(priceGroupId));
    }

    public List<UserDTO> findAllAdminAndSuperAdminUsers() {
        return userMapper.toDto(userRepository.findAllAdminAndSuperAdminUsers());
    }

    public UserDTO getCurrentUser() {
        try {
            String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return findByUsername(username);
        } catch (ClassCastException e) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return findByUsername(user.getUsername());
        }

    }

}
