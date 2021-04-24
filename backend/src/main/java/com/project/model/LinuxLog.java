package com.project.model;

import javax.persistence.*;

@Entity
@Table(name = "linux_logs")

public class LinuxLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long index;

    private String hostname;
    private int priority;
    private String source;
    private String message;
    private String login;

    public LinuxLog() {
    }

    public LinuxLog(long index, String hostname, int priority, String source, String message,String login) {
        this.index = index;
        this.hostname = hostname;
        this.priority = priority;
        this.source = source;
        this.message = message;
        this.login = login;
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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
