package com.perso.sports.entity;

import com.perso.sports.entity.presenter.ExercisePresenter;


import java.util.List;
import java.util.stream.Collectors;

public class ExerciseEntity {

    private int repetitions;

    private int weight;

    private Integer idMovement;


    public ExerciseEntity() {
    }


    public ExerciseEntity(int repetitions, int weight, Integer idMovement) {
        this.repetitions = repetitions;
        this.weight = weight;
        this.idMovement = idMovement;
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

    public Integer getIdMovement() {
        return idMovement;
    }

    public void setIdMovement(Integer idMovement) {
        this.idMovement = idMovement;
    }

    public  static List<ExerciseEntity> fromPresenter(List<ExercisePresenter> exercisePresenters) {
        return exercisePresenters.stream()
                .map(ExerciseEntity::fromPresenter)
                .collect(Collectors.toList());
    }

    public  static ExerciseEntity fromPresenter(ExercisePresenter exercisePresenter) {
        int repetitions = exercisePresenter.getRepetitions();
        int weight = exercisePresenter.getWeight();
        Integer idMovements = exercisePresenter.getMovements().getId();
        return  new ExerciseEntity( repetitions, weight, idMovements);
    }
}