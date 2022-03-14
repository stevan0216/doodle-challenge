package com.stevan.challenge.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * <p>Class representing poll participants.</p>
 * <p>Participant can be anybody, so nothing more than a name is required.</p>
 */

@Entity
@Table(name = "participant")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_participant")
    private Integer idParticipant;

    @Column(name = "name")
    private String name;

    public Participant() {}

    public Participant(int idParticipant, String name) {
        this.idParticipant = idParticipant;
        this.name = name;
    }

    public int getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(int idParticipant) {
        this.idParticipant = idParticipant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return idParticipant == that.idParticipant &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idParticipant, name);
    }
}
