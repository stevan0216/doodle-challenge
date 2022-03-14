package com.stevan.challenge.dto;

import com.stevan.challenge.entity.Option;

/**
 * <p>Simple factory class used to create {@link Option} object based on option type.</p>
 * <p>Possible results are {@link TextOptionDto} textOptionDto and {@link DateOptionDto} dateOptionDto objects.</p>
 */
public class OptionDtoFactory {

    public static OptionDto getOptionDto(Option option) {
        if( option.getType() == Option.Type.TEXT ) {
            return new TextOptionDto(option);
        }else if( option.getType() == Option.Type.DATE ) {
            return new DateOptionDto(option);
        }
        throw new RuntimeException("Unsupported option type: " + option.getType());
    }
}
