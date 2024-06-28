package com.sar.goldapp.model.authentication;

import com.sar.goldapp.model.Person;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.*;

@Entity
@Table(name = "auth_user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_seq", allocationSize = 1, initialValue = 5)
    private long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "locked", nullable = false)
    private boolean lock;

    @Column(name = "enabled", nullable = false)
    private boolean enable;

    @Column(name = "expired", nullable = false)
    private Instant expired = ZonedDateTime.now().plusYears(1L).toInstant();

    @Column(name = "credential", nullable = false)
    private boolean credential;

    @Column(name = "code", nullable = false)
    private String code;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Set<Group> groups = new HashSet<>();

    @OneToOne(cascade = CascadeType.MERGE, optional = false)
    private Person person;

    @OneToOne(mappedBy = "user")
    private RefreshToken refreshToken;

    public User() {
    }

    public User(String username, String password, boolean lock, boolean enable, Instant expired,
                boolean credential, String code) {
        this.username = username;
        this.password = password;
        this.lock = lock;
        this.enable = enable;
        this.expired = expired;
        this.credential = credential;
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

    @Override
    public boolean isAccountNonExpired() {
        return (expired.isAfter(ZonedDateTime.now().toInstant()));
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isLock();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredential();
    }

    @Override
    public boolean isEnabled() {
        return isEnable();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Group group: groups) {
            grantedAuthorities.addAll(group.getPermissions());
        }
        return grantedAuthorities;
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

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public RefreshToken getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(RefreshToken refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", lock=" + lock +
                ", enable=" + enable +
                ", expired=" + expired +
                ", credential=" + credential +
                ", groups=" + groups +
                ", person=" + person +
                ", code='" + code + '\'' +
                '}';
    }

}
