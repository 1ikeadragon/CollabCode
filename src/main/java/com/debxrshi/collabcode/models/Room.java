package com.debxrshi.collabcode.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "creatorID")
    private long creatorID;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "code")
    private String code;

    @Column(name = "lang")
    private String lang;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}