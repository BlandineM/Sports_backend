package com.perso.sports.entity.presenter;

import java.time.Instant;
import java.util.List;
import java.util.UUID;


public class SessionPresenter {


    private UUID id;
    private List<ExercisePresenter> exercises;
    private UserPresenter user;
    private Instant date;
    private String name;

    public SessionPresenter(){}

    public SessionPresenter(UUID id, List<ExercisePresenter> exercises, UserPresenter user, Instant date, String name) {
        this.id = id;
        this.exercises = exercises;
        this.user = user;
        this.date = date;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<ExercisePresenter> getExercises() {
        return exercises;
    }

    public void setExercises(List<ExercisePresenter> exercises) {
        this.exercises = exercises;
    }

    public UserPresenter getUser() {
        return user;
    }

    public void setUser(UserPresenter user) {
        this.user = user;
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
