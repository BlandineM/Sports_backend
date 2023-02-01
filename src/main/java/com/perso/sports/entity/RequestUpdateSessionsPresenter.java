package com.perso.sports.entity;

import java.time.Instant;

public class RequestUpdateSessionsPresenter {
    private Long idMovements;
    private Long idSessions;
    private Long idUsers;
    private Instant date;
    private int repetitions;
    private int weight;
    private String name;

    public Long getIdSessions() {
        return idSessions;
    }

    public Long getIdMovements() {
        return idMovements;
    }

    public Long getIdUsers() {
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
