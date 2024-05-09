package com.debxrshi.collabcode.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Rooms", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"creatorID"}),
        @UniqueConstraint(columnNames = {"uuid"})
})
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "creatorID")
    private String creatorId;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "lang")
    private String lang;

    @Column(name = "key")
    private String key;

    @Column(name = "code")
    String code;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCode() {
        return code;
    }

    public void setCode(){
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "Room[id="+id+",creatorID="+creatorId+",uuid="+uuid+",key="+key+",lang"+lang+",code"+code+"]";
    }
}
