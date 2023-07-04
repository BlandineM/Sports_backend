package com.perso.sports.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.Instant;

@Entity
public class Sessions {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_movements")
    private Integer idMovements;
    @Column(name = "id_users")
    private Integer idUsers;
    @Column(name = "date")
    private Instant date;
    @Column(name = "repetitions")
    private int repetitions;

    @Column(name = "weight")
    private int weight;

    @Column(name = "name")
    private String name;

    public Sessions (){}

    public Sessions(Integer id, Integer idMovements, Integer idUsers, Instant date, int repetitions, int weight, String name) {
        this.id = id;
        this.idMovements = idMovements;
        this.idUsers = idUsers;
        this.date = date;
        this.repetitions = repetitions;
        this.weight = weight;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdMovements() {
        return idMovements;
    }

    public void setIdMovements(Integer idMovements) {
        this.idMovements = idMovements;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
