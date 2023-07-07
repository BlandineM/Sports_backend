package com.perso.sports.entity;

import com.perso.sports.entity.presenter.ExercisePresenter;

import java.time.Instant;
import java.util.List;

public class RequestUpdateSessionsPresenter {
    private Integer idSessions;
    private Integer idUsers;
    private Instant date;
    private String name;

    private List<ExercisePresenter> exercises;



    public List<ExercisePresenter> getExercises() {
        return exercises;
    }
    public Integer getIdSessions() {
        return idSessions;
    }

    public Integer getIdUsers() {
        return idUsers;
    }

    public Instant getDate() {
        return date;
    }

    public String getName() {
        return name;
    }
}
