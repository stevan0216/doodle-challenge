package com.stevan.challenge.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * <p>Class which represents one poll option answer, or participant preference.</p>
 * <p>Stores info about certain poll option, about participant and the preference itself.</p>
 */

@Entity
@Table(name = "preference")
public class Preference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_preference")
    private Integer idPreference;

    @Column(name = "poll_option_id")
    private Integer pollOptionId;

    @Column(name = "participant_id")
    private Integer participantId;

    @Column(name = "answer")
    private Byte answer;

    public Preference() {}

    public Preference(int idPreference, int pollOptionId, int participantId, Byte answer) {
        this.idPreference = idPreference;
        this.pollOptionId = pollOptionId;
        this.participantId = participantId;
        this.answer = answer;
    }

    public int getIdPreference() {
        return idPreference;
    }

    public void setIdPreference(int idPreference) {
        this.idPreference = idPreference;
    }

    public Byte getAnswer() {
        return answer;
    }

    public void setAnswer(Byte answer) {
        this.answer = answer;
    }

    public int getPollOptionId() {
        return pollOptionId;
    }

    public void setPollOptionId(int pollOptionId) {
        this.pollOptionId = pollOptionId;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Preference that = (Preference) o;
        return idPreference == that.idPreference &&
                Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPreference, answer);
    }

    @Override
    public String toString() {
        return "Preference{" +
                "idPreference=" + idPreference +
                ", pollOptionId=" + pollOptionId +
                ", participantId=" + participantId +
                ", answer=" + answer +
                '}';
    }
}
