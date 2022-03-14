package com.stevan.challenge.dto;

import com.stevan.challenge.entity.Option;

public class TextOptionDto extends OptionDto {

    private String text;

    public TextOptionDto(Option option) {
        this.text = option.getText();
    }

    public TextOptionDto(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
