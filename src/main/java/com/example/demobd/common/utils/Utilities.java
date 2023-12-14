package com.example.demobd.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Utilities implements ValidateDate {

    private final String dateFormat;

    public Utilities(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public boolean isValid(String dateStr) {
        var sdf = new SimpleDateFormat(this.dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static String getTimestampValue() {
        var zoneIdCo = ZoneId.of("America/Bogota");
        var now = ZonedDateTime.now(zoneIdCo);
        var dtf = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        return now.truncatedTo(ChronoUnit.MILLIS).format(dtf);
    }
}
