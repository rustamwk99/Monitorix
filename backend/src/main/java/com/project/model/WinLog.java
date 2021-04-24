package com.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "win_logs")
public class WinLog {
    @Id
    private long index;
    private String description;
    private String source;
    private long instance_id;

    private String message;

    private String login;
    public WinLog() {
    }

    public WinLog(long index, String description, String source, long instance_id, String message, String login) {
        this.index = index;
        this.description = description;
        this.source = source;
        this.instance_id = instance_id;
        this.message = message;
        this.login = login;
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public long getInstanceId() {
        return instance_id;
    }

    public void setInstanceId(long instance_id) {
        this.instance_id = instance_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
