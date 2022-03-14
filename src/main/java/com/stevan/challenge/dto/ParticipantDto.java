package com.stevan.challenge.dto;

import java.io.Serializable;
import java.util.List;

/**
 * <p>DTO class representing encapsulated participant data </p>
 * <p>including participant's preferences for certain polls.</p>
 */
public class ParticipantDto implements Serializable {

    private int id;
    private String name;
    private List<Short> preferences;

    public ParticipantDto(int id, String name, List<Short> preferences) {
        this.id = id;
        this.name = name;
        this.preferences = preferences;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Short> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<Short> preferences) {
        this.preferences = preferences;
    }

    @Override
    public String toString() {
        return "ParticipantDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", preferences=" + preferences +
                '}';
    }
}
