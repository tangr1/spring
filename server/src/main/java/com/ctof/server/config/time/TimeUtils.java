package com.ctof.server.config.time;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class TimeUtils {
    private static DateTimeFormatter utc_fmt = ISODateTimeFormat.dateTimeNoMillis().withZoneUTC();

    private TimeUtils() {
    }

    public static DateTime now() {
        return new DateTime();
    }

    /**
     * Generate ISO8601 String
     *
     * @param t
     * @return
     */
    public static String toISOString(DateTime t) {
        if (t == null) {
            return "";
        }
        return utc_fmt.print(t);
    }

    /**
     * Parse DateTime from ISO8601 string
     *
     * @param time
     * @return
     */
    public static DateTime fromISOString(String time) {
        if (time == null || time.isEmpty()) {
            return null;
        }
        return utc_fmt.parseDateTime(time);
    }
}
