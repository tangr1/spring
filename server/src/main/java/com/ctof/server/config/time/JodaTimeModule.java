package com.ctof.server.config.time;

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.joda.time.DateTime;

public class JodaTimeModule extends SimpleModule {
    public JodaTimeModule() {
        super();
        addSerializer(DateTime.class, new ISO8601TimeSerializer());
        addDeserializer(DateTime.class, new ISO8601TimeDeserializer());
    }
}
