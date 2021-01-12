package com.data.models.users;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
public class UserRole implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ROLE_ID_SEQ")
    @SequenceGenerator(name = "USER_ROLE_ID_SEQ", sequenceName = "USER_ROLE_ID_SEQ", allocationSize = 1)
    private long id;
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "userRole")
    private List<User> users = new ArrayList<>();
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "role_permission", joinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "PERM_ID", referencedColumnName = "id"))
    private List<com.data.models.store.Heplers.UserPermission> userPermissions = new ArrayList<>();
    private boolean status;


    public UserRole() {
    }

    public UserRole(String name) {
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

    public List<com.data.models.store.Heplers.UserPermission> getUserPermissions() {
        return userPermissions;
    }

    public void setUserPermissions(List<com.data.models.store.Heplers.UserPermission> userPermissions) {
        this.userPermissions = userPermissions;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserRole [id=" + id + ", name=" + name + ", userPermissions=" + userPermissions + ", status=" + status
                + "]";
    }


}
