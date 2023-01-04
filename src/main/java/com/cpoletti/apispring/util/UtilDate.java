package com.cpoletti.apispring.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class UtilDate {

    public static int calculateAge(Calendar birthDate, Calendar currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(LocalDate.ofInstant(birthDate.toInstant(), ZoneId.systemDefault())
                                ,LocalDate.ofInstant(currentDate.toInstant(), ZoneId.systemDefault())).getYears();
        } else {
            return 0;
        }
    }

    public static int calculateAge(Calendar birthDate) {
        return UtilDate.calculateAge(birthDate, Calendar.getInstance());
    }
}
