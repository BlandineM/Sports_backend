package com.perso.sports.entity;

import com.perso.sports.entity.presenter.ExercisePresenter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Exercise {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "repetitions")
    private int repetitions;

    @Column(name = "weight")
    private int weight;

    @Column(name = "id_movements")
    private Integer idMovements;


    public Exercise(){}

    public Exercise(Integer id, int repetitions, int weight, Integer idMovements) {
        this.id = id;
        this.repetitions = repetitions;
        this.weight = weight;
        this.idMovements = idMovements;
    }

    public  static List<Exercise> fromPresenter(List<ExercisePresenter> exercisePresenters) {
        return exercisePresenters.stream()
                .map(Exercise::fromPresenter)
                .collect(Collectors.toList());
    }

    public  static Exercise fromPresenter(ExercisePresenter exercisePresenter) {
        Integer id = exercisePresenter.getId();
        int repetitions = exercisePresenter.getRepetitions();
        int weight = exercisePresenter.getWeight();
        Integer idMovements = exercisePresenter.getMovements().getId();
        return  new Exercise(id, repetitions, weight, idMovements);
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

    public Integer getIdMovements() {
        return idMovements;
    }

    public void setIdMovements(Integer idMovements) {
        this.idMovements = idMovements;
    }
}

