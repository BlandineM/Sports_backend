package com.perso.sports.entity;

public class Movements {
    private Long idMovements;
    private String name;
    private String shortName;
    private String description;

    public Movements(){}

    public Movements(Long idMovements, String name, String shortName, String description){
        this.idMovements = idMovements;
        this.name = name;
        this.shortName = shortName;;
        this.description = description;
    }

    public Long getIdMovements() {return idMovements;}

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdMovements(Long idMovements) {
        this.idMovements = idMovements;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
