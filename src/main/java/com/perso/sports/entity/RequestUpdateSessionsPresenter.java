package com.perso.sports.entity;

import java.time.Instant;

public class RequestUpdateSessionsPresenter {
    private Integer idMovements;
    private Integer idSessions;
    private Integer idUsers;
    private Instant date;
    private int repetitions;
    private int weight;
    private String name;

    public Integer getIdSessions() {
        return idSessions;
    }

    public Integer getIdMovements() {
        return idMovements;
    }

    public Integer getIdUsers() {
        return idUsers;
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
