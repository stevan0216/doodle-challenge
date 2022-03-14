package com.stevan.challenge.entity;

import javax.persistence.*;

/**
 * <p>Class representing poll options.</p>
 * <p>Option has it's type ({@link Type}) based on which is decided which fields should be used.</p>
 * <p>For every type, different subset of fields is used.</p>
 */

@Entity
@Table(name = "proposal")
public class Option {

    public enum Type{
        TEXT("TEXT"),
        DATE("DATE");
        final String type;
        Type(String type) {
            this.type = type;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_option")
    private Integer idOption;

    @Column(name = "option_type", columnDefinition = "enum('TEXT','DATE')")
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "available")
    private Byte available;

    @Column(name = "option_text")
    private String optionText;

    @Column(name = "start_time")
    private Long startTime;

    @Column(name = "end_time")
    private Long endTime;

    @Column(name = "start_date")
    private Long startDate;

    @Column(name = "end_date")
    private Long endDate;

    @Column(name = "current_date")
    private Long currentDate;

    @Column(name = "all_day")
    private Byte allDay;

    public Option() {}

    public Option(int idOption, Type type, Byte available, String text, Long startTime, Long endTime, Long startDate, Long endDate, Long currentDate, Byte allDay) {
        this.idOption = idOption;
        this.type = type;
        this.available = available;
        this.optionText = text;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currentDate = currentDate;
        this.allDay = allDay;
    }

    public int getIdOption() {
        return idOption;
    }

    public void setIdOption(int idOption) {
        this.idOption = idOption;
    }

    public Byte getAvailable() {
        return available;
    }

    public void setAvailable(Byte available) {
        this.available = available;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getText() {
        return optionText;
    }

    public void setText(String text) {
        this.optionText = text;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public Long getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Long currentDate) {
        this.currentDate = currentDate;
    }

    public Byte getAllDay() {
        return allDay;
    }

    public void setAllDay(Byte allDay) {
        this.allDay = allDay;
    }
}
