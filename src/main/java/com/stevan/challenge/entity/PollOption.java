package com.stevan.challenge.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * <p>Class which connects {@link Poll} and {@link Option} classes.</p>
 * <p>Represents an option associated with poll, which is why it stores poll id and option id.</p>
 */

@Entity
@Table(name = "poll_option")
public class PollOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_poll_option")
    private Integer idPollOption;

    @Column(name = "option_id")
    private Integer optionId;

    @Column(name = "poll_id")
    private String pollId;

    public PollOption() {}

    public PollOption(int idPollOption, int optionId, String pollId) {
        this.idPollOption = idPollOption;
        this.optionId = optionId;
        this.pollId = pollId;
    }

    public int getOptionId() { return optionId; }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    public String getPollId() {
        return pollId;
    }

    public void setPollId(String pollId) {
        this.pollId = pollId;
    }

    public int getIdPollOption() {
        return idPollOption;
    }

    public void setIdPollOption(int idPollOption) {
        this.idPollOption = idPollOption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PollOption that = (PollOption) o;
        return idPollOption == that.idPollOption;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPollOption);
    }
}
