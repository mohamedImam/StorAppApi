package com.data.models.store.users;

import com.data.models.users.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.data.models.enums.UserOperations;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserPermission  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_PERMISSION_ID_SEQ")
    @SequenceGenerator(name = "USER_PERMISSION_ID_SEQ", sequenceName = "USER_PERMISSION_ID_SEQ", allocationSize = 1)
    private long id;
    @Column(unique = true)
    private String name;
    private String pageName;
    @JsonIgnore
    @ManyToMany(mappedBy = "userPermissions")
    private List<UserRole> roles = new ArrayList<>();
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @JoinTable(name = "permission_operation")
    private List<UserOperations> userOperations = new ArrayList<>();
    private boolean status;

    public UserPermission() {
    }

    public UserPermission(String name) {
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

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    public List<UserOperations> getUserOperations() {
        return userOperations;
    }

    public void setUserOperations(List<UserOperations> userOperations) {
        this.userOperations = userOperations;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserPermission [id=" + id + ", name=" + name + ", pageName=" + pageName + ", userOperations="
                + userOperations + ", status=" + status + "]";
    }
}
