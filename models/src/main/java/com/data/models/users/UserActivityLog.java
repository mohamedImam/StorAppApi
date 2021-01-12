package com.data.models.store.Heplers;

import com.data.models.enums.PageName;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class UserActivityLog implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY , generator = "USER_ACTIVITY_ID_SEQ")
    @SequenceGenerator(name = "USER_ACTIVITY_ID_SEQ", sequenceName = "USER_ACTIVITY_ID_SEQ", allocationSize = 1)
    private long id;
    private String userName;
    private String ip;
    @Enumerated(EnumType.STRING)
    private PageName pageName;
    @Lob
    private String description;
    @CreationTimestamp
    private LocalDateTime dataTime;
    private boolean success;


    public UserActivityLog() {
    }

    public UserActivityLog(String userName, String ip, PageName pageName, String description, boolean success) {
        this.userName = userName;
        this.ip = ip;
        this.pageName = pageName;
        this.description = description;
        this.success = success;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public PageName getPageName() {
        return pageName;
    }

    public void setPageName(PageName pageName) {
        this.pageName = pageName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDataTime() {
        return dataTime;
    }

    public void setDataTime(LocalDateTime dataTime) {
        this.dataTime = dataTime;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


}
