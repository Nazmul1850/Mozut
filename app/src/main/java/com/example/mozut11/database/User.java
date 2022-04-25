package com.example.mozut11.database;

import java.io.Serializable;

public class User implements Serializable {
    private String name,phone_number,email,type,id;
    public User(String name,String phone_number,String email,String type)
    {
        this.email = email;
        this.name = name;
        this.phone_number = phone_number;
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getType() {
        return type;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setType(String type) {
        this.type = type;
    }

}
