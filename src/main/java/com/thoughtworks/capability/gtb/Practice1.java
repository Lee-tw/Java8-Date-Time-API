package com.thoughtworks.capability.gtb;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * 计算任意日期与下一个劳动节相差多少天
 *
 * @author itutry
 * @create 2020-05-15_16:33
 */
public class Practice1 {

    public static long getDaysBetweenNextLaborDay(LocalDate date) {
        LocalDate laborDay = LocalDate.of(date.getYear(), 5, 1);
        LocalDate nextLaborDay;
        if (date.isAfter(laborDay)) {
            nextLaborDay = laborDay.plusYears(1);
            return ChronoUnit.DAYS.between(date, nextLaborDay);
            //return nextLaborDay.toEpochDay() - date.toEpochDay();
        }
        return ChronoUnit.DAYS.between(date, laborDay);
        //return laborDay.toEpochDay() - date.toEpochDay();
    }
}
