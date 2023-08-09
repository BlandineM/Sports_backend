package com.perso.sports.entity;

import com.perso.sports.entity.presenter.ExercisePresenter;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class RequestAddSessionPresenter {

    private UUID idUser;
    private Instant date;
    private int repetitions;
    private int weight;
    private String name;

    private List<ExercisePresenter> exercises;

    public List<ExercisePresenter> getExercises() {
        return exercises;
    }

    public UUID getIdUser() {
        return idUser;
    }

    public Instant getDate() {
        return date;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
