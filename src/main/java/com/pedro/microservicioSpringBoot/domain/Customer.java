package com.pedro.microservicioSpringBoot.domain;

public class Customer {

    private String ID;
    private String name;
    private String username;
    private String password;

    public Customer(String ID, String name, String username, String password) {
        this.ID = ID;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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
