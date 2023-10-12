package com.perso.sports.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "user")
public class UserEntity {

    @Id
    private UUID id;

    private String name;


    public UserEntity(){
    }

    public UserEntity(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static UserEntity create(String name) {
        return new UserEntity(UUID.randomUUID(), name);
    }
}
