package com.ctof.server.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Converte boolean type to 'Y' or 'N' in database
 */
@Converter
public class BooleanToStringConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean value) {
        return (value != null && value) ? "Y" : "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String value) {
        if (value == null) {
            return false;
        } else {
            return "Y".equals(value);
        }
    }
}
