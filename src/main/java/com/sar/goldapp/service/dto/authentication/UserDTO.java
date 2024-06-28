package com.sar.goldapp.service.dto.authentication;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sar.goldapp.service.dto.PersonDTO;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UserDTO {

    private long id;

    private String username;

    private String password;

    private boolean lock;

    private boolean enable;

    private String code;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "UTC")
    private Instant expired = ZonedDateTime.now().plusYears(1L).toInstant();

    private boolean credential;

    private Set<GroupDTO> groups = new HashSet<>();


    private PersonDTO person;

    public UserDTO() {
    }

    public UserDTO(long id, String username, String password, boolean lock, boolean enable, Instant expired,
                   boolean credential, Set<GroupDTO> groups, PersonDTO person,
                   String code) {
        this.id = id;
        this.username = username;
        this.lock = lock;
        this.enable = enable;
        this.expired = expired;
        this.credential = credential;
        this.groups = groups;
        this.person = person;
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Instant getExpired() {
        return expired;
    }

    public void setExpired(Instant expired) {
        this.expired = expired;
    }

    public boolean isCredential() {
        return credential;
    }

    public void setCredential(boolean credential) {
        this.credential = credential;
    }

    public Set<GroupDTO> getGroups() {
        return groups;
    }

    public void setGroups(Set<GroupDTO> groups) {
        this.groups = groups;
    }

    public PersonDTO getPerson() {
        return person;
    }

    public void setPerson(PersonDTO person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return id == userDTO.id && Objects.equals(username, userDTO.username);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", lock=" + lock +
                ", enable=" + enable +
                ", code=" + code +
                ", expired=" + expired +
                ", credential=" + credential +
                ", groups=" + groups +
                ", userProfile=" + person +
                '}';
    }

}
