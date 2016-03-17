package model;

import java.io.Serializable;


public class User implements Serializable {

    private int id;

    private String name;

    private String username;

    private String password;

    private String gender;
    private int age;


    @Override
    public String toString() {
        return "This is " + name + " with username " + username;
    }

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

