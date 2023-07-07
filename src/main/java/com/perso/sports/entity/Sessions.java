package com.perso.sports.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.Instant;
import java.util.List;

@Entity
public class Sessions {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "exercises")
    private List<Exercise> exercises;
    @Column(name = "id_users")
    private Integer idUsers;
    @Column(name = "date")
    private Instant date;

    @Column(name = "name")
    private String name;

    public Sessions (){}


    public Sessions(Integer id, List<Exercise> exercises, Integer idUsers, Instant date, String name) {
        this.id = id;
        this.exercises = exercises;
        this.idUsers = idUsers;
        this.date = date;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public Integer getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Integer idUsers) {
        this.idUsers = idUsers;
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
