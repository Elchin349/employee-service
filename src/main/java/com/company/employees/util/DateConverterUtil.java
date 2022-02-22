package com.company.employees.util;

import com.company.employees.exception.BusinessExceptionEnum;
import com.company.employees.exception.DateTimeFormatException;
import com.company.employees.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateConverterUtil {

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd hh:mm:ss";

    public static LocalDate toLocalDate(String localDate) {
        verifyDateFormat(localDate);
        return LocalDate.parse(localDate);
    }

    public static LocalDateTime toLocalDateTime(String localDateTime) {
        verifyDateTimeFormat(localDateTime);
        return LocalDateTime.parse(localDateTime);
    }

    private static void verifyDateFormat(String date) {
        try {
            LocalDate.parse(date, DateTimeFormatter.ofPattern(DATE_FORMAT));
        } catch (Exception e) {
            throw new DateTimeFormatException(BusinessExceptionEnum.DATE_FORMAT_ERROR);
        }
    }

    private static void verifyDateTimeFormat(String date) {
        try {
            LocalDate.parse(date, DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
        } catch (Exception e) {
            throw new DateTimeFormatException(BusinessExceptionEnum.DATE_TIME_FORMAT_ERROR);
        }
    }

    // string ve ya long ve ya offseet e vermek istesne bura yaz

}
