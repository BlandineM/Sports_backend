package com.perso.sports.entity;

import com.perso.sports.entity.presenter.ExercisePresenter;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class RequestUpdateSessionPresenter {
    private UUID idSessions;
    private UUID idUsers;
    private Instant date;
    private String name;

    private List<ExercisePresenter> exercises;



    public List<ExercisePresenter> getExercises() {
        return exercises;
    }
    public UUID getIdSessions() {
        return idSessions;
    }

    public UUID getIdUsers() {
        return idUsers;
    }

    public Instant getDate() {
        return date;
    }

    public String getName() {
        return name;
    }
}
