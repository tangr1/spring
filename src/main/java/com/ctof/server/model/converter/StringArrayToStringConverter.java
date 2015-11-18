/*
 * ******************************************************
 * Copyright VMware, Inc. 2014.   All Rights Reserved.
 * ******************************************************
 */

package com.ctof.server.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class StringArrayToStringConverter implements AttributeConverter<String[], String> {
    @Override
    public String convertToDatabaseColumn(String[] strings) {
        return String.join(",", strings);
    }

    @Override
    public String[] convertToEntityAttribute(String string) {
        return string.split(",");
    }
}