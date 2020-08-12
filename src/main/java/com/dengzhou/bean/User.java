package com.dengzhou.bean;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;
    private String name;
    private String realname;

    public User() {
    }

    public User(Integer id, String name, String realname) {
        this.id = id;
        this.name = name;
        this.realname = realname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", realname='" + realname + '\'' +
                '}';
    }
}
