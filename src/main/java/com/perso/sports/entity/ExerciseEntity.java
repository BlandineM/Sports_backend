package com.perso.sports.entity;

import com.perso.sports.entity.presenter.ExercisePresenter;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ExerciseEntity {

    private int repetitions;

    private int numberSerie;

    private int weight;

    private UUID idMovement;


    public ExerciseEntity() {
    }


    public ExerciseEntity(int repetitions, int numberSerie, int weight, UUID idMovement) {
        this.repetitions = repetitions;
        this.numberSerie = numberSerie;
        this.weight = weight;
        this.idMovement = idMovement;
    }

    public int getNumberSerie() {
        return numberSerie;
    }

    public void setNumberSerie(int numberSerie) {
        this.numberSerie = numberSerie;
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

    public UUID getIdMovement() {
        return idMovement;
    }

    public void setIdMovement(UUID idMovement) {
        this.idMovement = idMovement;
    }

    public  static List<ExerciseEntity> fromPresenter(List<ExercisePresenter> exercisePresenters) {
        return exercisePresenters.stream()
                .map(ExerciseEntity::fromPresenter)
                .collect(Collectors.toList());
    }

    public  static ExerciseEntity fromPresenter(ExercisePresenter exercisePresenter) {
        int repetitions = exercisePresenter.getRepetitions();
        int numberSerie = exercisePresenter.getNumberSerie();
        int weight = exercisePresenter.getWeight();
        UUID idMovements = exercisePresenter.getMovement().getId();
        return  new ExerciseEntity( repetitions, numberSerie, weight, idMovements);
    }
}