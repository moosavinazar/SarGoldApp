package com.sar.goldapp.model.authentication;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "auth_permission")
public class Permission implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_permission")
    @SequenceGenerator(name = "group_permission", sequenceName = "permission_seq", allocationSize = 1, initialValue = 5)
    private long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    public Permission() {
    }

    public Permission(String name) {
        this.name = name;
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

    @Override
    public String getAuthority() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
