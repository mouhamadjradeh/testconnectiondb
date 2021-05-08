package com.mouhamadjradeh.testconnectiondb.appuser;
//this is for the user itself
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity //this will be a table in our database
public class AppUser implements UserDetails {
//name of sequence generator for Id
@SequenceGenerator(name="student_sequence_generator",
        sequenceName ="student_sequence",allocationSize = 1)
@Id
@GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "student_sequence_generator")
private Long Id;
    private String name;
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)//since it is an enum type
    private AppUserRole appUserRole;
    private Boolean locked;
    private Boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority=new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singleton(authority);
    }
//constructor without ID
    public AppUser(String name, String username, String email, String password,
                   AppUserRole appUserRole, Boolean locked, Boolean enabled) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;
        this.locked = locked;
        this.enabled = enabled;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
