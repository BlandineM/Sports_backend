package com.perso.sports.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Document(collection = "session")
public class SessionEntity {

    @Id
    private UUID id;
    private List<ExerciseEntity> exercises;
    private UUID idUser;
    private Instant date;
    private String name;

    public SessionEntity(){}


    public SessionEntity(UUID id, List<ExerciseEntity> exercises, UUID idUser, Instant date, String name) {
        this.id = id;
        this.exercises = exercises;
        this.idUser = idUser;
        this.date = date;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<ExerciseEntity> getExercises() {
        return exercises;
    }

    public void setExercises(List<ExerciseEntity> exercises) {
        this.exercises = exercises;
    }

    public UUID getIdUser() {
        return idUser;
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
