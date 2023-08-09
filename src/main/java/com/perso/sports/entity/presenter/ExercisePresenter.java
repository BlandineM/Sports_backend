package com.perso.sports.entity.presenter;

import java.util.UUID;

public class ExercisePresenter {

    private UUID id;

    private int repetitions;

    private int numberSerie;

    private int weight;

    private MovementPresenter movements;


    public ExercisePresenter(){}

    public ExercisePresenter(UUID id, int repetitions, int numberSerie, int weight, MovementPresenter movements) {
        this.id = id;
        this.repetitions = repetitions;
        this.numberSerie = numberSerie;
        this.weight = weight;
        this.movements = movements;
    }

    public int getNumberSerie() {
        return numberSerie;
    }

    public void setNumberSerie(int numberSerie) {
        this.numberSerie = numberSerie;
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