package com.perso.sports.entity.presenter;

public class ExercisePresenter {

    private Integer id;

    private int repetitions;

    private int weight;

    private MovementPresenter movements;


    public ExercisePresenter(){}

    public ExercisePresenter(Integer id, int repetitions, int weight, MovementPresenter movements) {
        this.id = id;
        this.repetitions = repetitions;
        this.weight = weight;
        this.movements = movements;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public MovementPresenter getMovements() {
        return movements;
    }

    public void setMovements(MovementPresenter movements) {
        this.movements = movements;
    }
}