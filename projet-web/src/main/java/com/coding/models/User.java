package com.coding.models;

public class User {

    private Integer id;
    private String username;
    private String pwd;

    public int getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return username;
    }
    public void setName(String username) {
        this.username = username;
    }
    public String getPassword() {
        return pwd;
    }
    public void setPassword(String pwd) {
        this.pwd = pwd;
    }
}
