package com.stevan.challenge.entity;

import javax.persistence.*;

/**
 * <p>Main class representing registered user.</p>
 * <p>Every user has it's id, name, unique email, password and</p>
 * <p>info about whether notifications are desired or not.</p>
 */

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String mail;

    @Column(name = "password")
    private String password;

    @Column(name = "notify")
    private Boolean notify;

    public User() {}

    public User(int idUser, String name, String mail, String password, boolean notify) {
        this.idUser = idUser;
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.notify = notify;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isNotify() {
        return notify;
    }

    public void setNotify(boolean notify) {
        this.notify = notify;
    }
}
