package com.sar.goldapp.service.dto.authentication;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class GroupDTO {

    private long id;

    private String name;

    private Set<PermissionDTO> permissions = new HashSet<>();

    public GroupDTO() {
    }

    public GroupDTO(String name, Set<PermissionDTO> permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PermissionDTO> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<PermissionDTO> permissions) {
        this.permissions = permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupDTO groupDTO = (GroupDTO) o;
        return id == groupDTO.id && Objects.equals(name, groupDTO.name);
    }

    @Override
    public String toString() {
        return "GroupDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", permissions=" + permissions +
                '}';
    }

}
