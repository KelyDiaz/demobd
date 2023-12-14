package com.example.demobd.common.utils;

import com.example.demobd.common.exception.MissingHeadersException;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@Slf4j
@Getter
@Setter
@Component
public class HeadersUtilities {

    private static final int TAM_SOURCE_FIELD = 40;
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
    private static final String REGEX_FORMAT = "[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}";

    private static final List<String> REQUIRED_HEADERS = Arrays.asList(
            Constants.AUTHORIZATION, Constants.SYSTEM, Constants.COUNTRY, Constants.LANG, Constants.ENTITY, Constants.SUBSYSTEM, Constants.ORIGINATOR, Constants.HEADER_UI, Constants.OPERATION, Constants.DESTINATION, Constants.EXECID, Constants.TIMESTAMP, Constants.MSGTYPE
    );

    public void validateHeaders(HttpHeaders headers) {
        validateHeadersContent(headers);
        validateTimeStamp(headers);
        validateExecId(headers);
    }

    public void validateHeadersContent(HttpHeaders headers) {
        for (String header : REQUIRED_HEADERS) {
            if (!headers.containsKey(header)) {
                throw new MissingHeadersException("El header " + header + " es requerido");
            }
        }
    }

    public void validateTimeStamp(HttpHeaders headers) {
        ValidateDate validator = new Utilities(DATE_FORMAT);
        if (!validator.isValid(headers.getFirst(Constants.TIMESTAMP))) {
            throw new MissingHeadersException("El formato del timestamp es inválido.");
        }
    }

    public void validateExecId(HttpHeaders headers) {
        if (!Pattern.matches(REGEX_FORMAT, headers.getFirst("execId"))) {
            throw new MissingHeadersException("El formato del execId es inválido.");
        }
    }

    public static String getTimestampValue() {
        var zoneIdCo = ZoneId.of("America/Bogota");
        var now = ZonedDateTime.now(zoneIdCo);
        var dtf = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        return now.truncatedTo(ChronoUnit.MILLIS).format(dtf);
    }

    public static boolean validateField(String source) {
        return !(source == null || source.isEmpty() || source.length() > TAM_SOURCE_FIELD);
    }
}
