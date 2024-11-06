package com.zerotoismail.librarymanagement.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormater {
    public static String localDateTimeToDateWithDash(LocalDateTime localDateTime) {
        return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(localDateTime);
    }

    public static LocalDateTime stringToDateWithDash(String date) {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}
