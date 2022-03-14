package com.stevan.challenge.dto;

import java.io.Serializable;

public abstract class OptionDto implements Serializable {

    protected boolean available;

    public boolean getAvailable() { return available; }
}
