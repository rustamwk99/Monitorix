package com.project.model;

import javax.persistence.*;

@Entity
@Table(name = "triggers")
public class Trigger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String trigger;
    private String login;
    private String os;

    public Trigger(long id, String trigger,String login,String os) {
        this.id = id;
        this.trigger = trigger;
        this.login = login;
        this.os = os;
    }

    public Trigger() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }
}
