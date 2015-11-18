/*
 * *****************************************************
 *  Copyright VMware, Inc. 2014.   All Rights Reserved.
 *  ******************************************************
 */

package com.ctof.server.config.time;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdScalarSerializer;
import org.joda.time.DateTime;

import java.io.IOException;

/*
 * normally this serializer is registered as a module at object mapper initialize stage, however, in some
 * cases during marshal data model, external object mapper is used, we should use annotation @JsonSerialize
 * instead in this case. Bellow is the data models being annotated.
 *
 * - AvailableRestoreWindow: when processing getInstance request
 * - Snapshot: when processing getSnapshot request
 */
public class ISO8601TimeSerializer extends StdScalarSerializer<DateTime> {
    public ISO8601TimeSerializer() {
        super(DateTime.class);
    }

    @Override
    public void serialize(DateTime value,
                          JsonGenerator jgen,
                          SerializerProvider provider) throws IOException, JsonProcessingException {
        jgen.writeString(TimeUtils.toISOString(value));
    }
}
