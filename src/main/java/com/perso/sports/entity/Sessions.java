package com.perso.sports.entity;

import java.time.Instant;
import java.util.Date;

public class Sessions {
    private Long idMovements;
    private Long idSessions;
    private Long idUsers;
    private Instant date;
    private int repetitions;
    private int weight;
    private String name;

    public Sessions (){}

    public Sessions(Long idMovements, Long idSessions, Long idUsers, Instant date, int repetitions, int weight, String name){
        this.idMovements = idMovements;
        this.idSessions = idSessions;
        this.idUsers = idUsers;
        this.name = name;
        this.weight = weight;
        this.date = date;
        this.repetitions = repetitions;
    }

    public void setIdMovements(Long idMovements) {
        this.idMovements = idMovements;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getName() {
        return name;
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

    public Long getIdSessions() {
        return idSessions;
    }

    public Long getIdMovements() {
        return idMovements;
    }

    public void setIdSessions(Long idSessions) {
        this.idSessions = idSessions;
    }

    public Long getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Long idUsers) {
        this.idUsers = idUsers;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
