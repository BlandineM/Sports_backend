package com.perso.sports.entity;

public class User {

    private Long idUsers;

    private String name;


    public User(){
    }

    public User(Long idUsers, String name){
        this.idUsers = idUsers;
        this.name = name;
    }

    public Long getIdUsers() {
        return idUsers;
    }

    public String getName() {
        return name;
    }

    public void setIdUsers(Long idUsers) {
        this.idUsers = idUsers;
    }

    public void setName(String name) {
        this.name = name;
    }
}
