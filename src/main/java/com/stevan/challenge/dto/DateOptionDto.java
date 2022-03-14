package com.stevan.challenge.dto;

import com.stevan.challenge.entity.Option;

import java.io.Serializable;

public class DateOptionDto extends OptionDto {

    private Long start;
    private Long end;
    private Long startDate;
    private Long endDate;
    private Long date;
    private Boolean allDay;

    public DateOptionDto(Option option) {
        this.start = option.getStartTime();
        this.end = option.getEndTime();
        this.startDate = option.getStartDate();
        this.endDate = option.getEndDate();
        this.date = option.getCurrentDate();
        this.allDay = option.getAllDay().shortValue() != 0;
    }

    public DateOptionDto(Long start, Long end, Long startDate, Long endDate, Long date, Boolean allDay) {
        this.start = start;
        this.end = end;
        this.startDate = startDate;
        this.endDate = endDate;
        this.date = date;
        this.allDay = allDay;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
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

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Boolean getAllDay() {
        return allDay;
    }

    public void setAllDay(Boolean allDay) {
        this.allDay = allDay;
    }
}
