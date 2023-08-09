package com.perso.sports.entity.presenter;

import java.util.UUID;

public class ExercisePresenter {

    private UUID id;

    private int repetitions;

    private int weight;

    private MovementPresenter movements;


    public ExercisePresenter(){}

    public ExercisePresenter(UUID id, int repetitions, int weight, MovementPresenter movement) {
        this.id = id;
        this.repetitions = repetitions;
        this.weight = weight;
        this.movements = movement;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public MovementPresenter getMovement() {
        return movements;
    }

    public void setMovement(MovementPresenter movement) {
        this.movements = movement;
    }
}