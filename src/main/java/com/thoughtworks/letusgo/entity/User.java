package com.thoughtworks.letusgo.entity;

public class User {
    private int id;
    private String name;
    private String password;
    private int rank;

    public User() {
    }

    public User(int id, String name, String password, int rank) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.rank = rank;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
