package com.lld.utils;

import javax.swing.text.DateFormatter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static String epochToString(Long epoch) {
        return epochToString(epoch, "dd:MM:yyyy HH:mm");
    }

    public static String epochToString(Long epoch, String pattern) {
        LocalDateTime dateTime = Instant.ofEpochMilli(epoch)
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return dateTime.format(formatter);
    }
}
