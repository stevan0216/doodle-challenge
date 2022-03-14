package com.stevan.challenge.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * <p>Class representing polls.</p>
 * <p>Everything important about poll is stored inside this class.</p>
 */

@Entity
@Table(name = "poll")
public class Poll {

    public enum Type{
        TEXT("TEXT"),
        DATE("DATE");
        final String type;
        Type(String type) {
            this.type = type;
        }
        public String getType() { return type; }
    }

    public enum PreferencesType{
        YESNO("YESNO"),
        YESNOIFNEEDBE("YESNOIFNEEDBE");
        final String type;
        PreferencesType(String type) {
            this.type = type;
        }
        public String getType() { return type; }
    }

    public enum State{
        OPEN("OPEN"),
        CLOSE("CLOSE");
        final String type;
        State(String type) {
            this.type = type;
        }
        public String getType() { return type; }
    }

    public enum Device{
        WEB("WEB");
        final String type;
        Device(String type) {
            this.type = type;
        }
        public String getType() { return type; }
    }

    public enum Levels{
        YESNO("YESNO"),
        YESNOIFNEEDBE("YESNOIFNEEDBE");
        final String type;
        Levels(String type) {
            this.type = type;
        }
        public String getType() { return type; }
    }

    @Id
    @Column(name = "id_poll")
    private String idPoll;

    @Column(name = "admin_key")
    private String adminKey;

    @Column(name = "latest_change")
    private Long latestChange;

    @Column(name = "initiated")
    private Long initiated;

    @Column(name = "type", columnDefinition = "enum('TEXT','DATE')")
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "hidden")
    private Byte hidden;

    @Column(name = "preferences_type", columnDefinition = "enum('YESNO', 'YESNOIFNEEDBE')")
    @Enumerated(EnumType.STRING)
    private PreferencesType preferencesType;

    @Column(name = "state", columnDefinition = "enum('OPEN', 'CLOSE')")
    @Enumerated(EnumType.STRING)
    private State state;

    @Column(name = "locale")
    private String locale;

    @Column(name = "title")
    private String title;

    @Column(name = "device", columnDefinition = "enum('WEB')")
    @Enumerated(EnumType.STRING)
    private Device device;

    @Column(name = "levels", columnDefinition = "enum('YESNO', 'YESNOIFNEEDBE')")
    @Enumerated(EnumType.STRING)
    private Levels levels;
    
    @Column(name = "initiator")
    private Integer initiator;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;

    public Poll() {}

    public Poll(String idPoll, String adminKey, Long latestChange, Long initiated, Type type, Byte hidden, PreferencesType preferencesType, State state, String locale, String title, Device device, Levels levels, int initiator, String location, String description) {
        this.idPoll = idPoll;
        this.adminKey = adminKey;
        this.latestChange = latestChange;
        this.initiated = initiated;
        this.type = type;
        this.hidden = hidden;
        this.preferencesType = preferencesType;
        this.state = state;
        this.locale = locale;
        this.title = title;
        this.device = device;
        this.levels = levels;
        this.initiator = initiator;
        this.location = location;
        this.description = description;
    }

    public String getAdminKey() {
        return adminKey;
    }

    public void setAdminKey(String adminKey) {
        this.adminKey = adminKey;
    }

    public Long getLatestChange() {
        return latestChange;
    }

    public Long getInitiated() {
        return initiated;
    }
    
    public Type getType() { return type; }

    public void setType(Type type) {
        this.type = type;
    }
    
    public Byte getHidden() {
        return hidden;
    }

    public void setHidden(Byte hidden) {
        this.hidden = hidden;
    }
    
    public PreferencesType getPreferencesType() {
        return preferencesType;
    }

    public void setPreferencesType(PreferencesType preferencesType) { this.preferencesType = preferencesType; }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    
    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
    
    public Levels getLevels() {
        return levels;
    }

    public void setLevels(Levels levels) {
        this.levels = levels;
    }
    
    public String getIdPoll() {
        return idPoll;
    }

    public void setIdPoll(String idPoll) {
        this.idPoll = idPoll;
    }

    public int getInitiator() { return initiator; }

    public void setInitiator(int initiator) {
        this.initiator = initiator;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setLatestChange(Long latestChange) {
        this.latestChange = latestChange;
    }

    public void setInitiated(Long initiated) {
        this.initiated = initiated;
    }

    public void setInitiator(Integer initiator) {
        this.initiator = initiator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Poll poll = (Poll) o;
        return Objects.equals(idPoll, poll.idPoll) && Objects.equals(adminKey, poll.adminKey) && Objects.equals(latestChange, poll.latestChange) && Objects.equals(initiated, poll.initiated) && type == poll.type && Objects.equals(hidden, poll.hidden) && preferencesType == poll.preferencesType && state == poll.state && Objects.equals(locale, poll.locale) && Objects.equals(title, poll.title) && device == poll.device && levels == poll.levels && Objects.equals(initiator, poll.initiator) && Objects.equals(location, poll.location) && Objects.equals(description, poll.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPoll, adminKey, latestChange, initiated, type, hidden, preferencesType, state, locale, title, device, levels, initiator, location, description);
    }

    @Override
    public String toString() {
        return "Poll{" +
                "idPoll='" + idPoll + '\'' +
                ", adminKey='" + adminKey + '\'' +
                ", latestChange=" + latestChange +
                ", initiated=" + initiated +
                ", type=" + type +
                ", hidden=" + hidden +
                ", preferencesType=" + preferencesType +
                ", state=" + state +
                ", locale='" + locale + '\'' +
                ", title='" + title + '\'' +
                ", device=" + device +
                ", levels=" + levels +
                ", initiator=" + initiator +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
