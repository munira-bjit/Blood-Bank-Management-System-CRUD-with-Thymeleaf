package com.munira.main.model;

public class Patient {

    private Integer id;
    private String name;
    private String bloodGroup;

    public Patient() {
    }

    public Patient(Integer id, String name, String bloodGroup) {
        this.id = id;
        this.name = name;
        this.bloodGroup = bloodGroup;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
