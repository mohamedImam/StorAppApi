package com.data.models.users;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.usertype.UserType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_SEQ")
    @SequenceGenerator(name = "USER_ID_SEQ", sequenceName = "USER_ID_SEQ" , allocationSize = 1)
    private long id;
    private String fullName;
    private String userName;
   // private UserType userType;
    private String password;
    @CreationTimestamp
    private LocalDateTime registeredDate;
    private LocalDateTime lastLogin;

    @ManyToOne(fetch = FetchType.EAGER)
    private UserRole userRole;


    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    private boolean sessionActive;
    private boolean status;

    public User() {
    }

    public User(String fullName, String userName, UserType userType, String password, LocalDateTime registeredDate, LocalDateTime lastLogin, UserRole userRole, boolean sessionActive, boolean status) {
        this.fullName = fullName;
        this.userName = userName;
        //this.userType = userType;
        this.password = password;
        this.registeredDate = registeredDate;
        this.lastLogin = lastLogin;
        this.userRole = userRole;
        this.sessionActive = sessionActive;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDateTime registeredDate) {
        this.registeredDate = registeredDate;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

   /* public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }*/

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isSessionActive() {
        return sessionActive;
    }

    public void setSessionActive(boolean sessionActive) {
        this.sessionActive = sessionActive;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", fullName=" + fullName + ", userName=" + userName + ", password=" + password
                + ", registeredDate=" + registeredDate + ", lastLogin=" + lastLogin
                + ", userRole=" + userRole + ", sessionActive=" + sessionActive + ", status=" + status + "]";
    }
}
