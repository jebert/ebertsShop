package com.eberts.shop.models.vo;

import com.eberts.shop.models.Permission;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class UserVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userName;

    private String fullName;

    private String password;
    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean accountNonExpired;
    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean accountNonLocked;
    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean credentialsNonExpired;
    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean enabled;

    private List<Permission> permissions;

    public UserVo() {
    }

    public UserVo(String userName, String fullName, String password, Boolean accountNonExpired, Boolean accountNonLocked, Boolean credentialsNonExpired, Boolean enabled) {
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
