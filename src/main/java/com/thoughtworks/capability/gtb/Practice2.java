package com.thoughtworks.capability.gtb;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

/**
 * 对任意日期获取下一个工作日, 不考虑节假日
 *
 * @author itutry
 * @create 2020-05-15_17:20
 */
public class Practice2 {

    public static LocalDate getNextWorkDate(LocalDate date) {
        LocalDate nextWorkDay;
        if (date.getDayOfWeek().getValue() >= 5) {
            nextWorkDay = date.plusWeeks(1).with(ChronoField.DAY_OF_WEEK, DayOfWeek.MONDAY.getValue());   // with(要调整的参数, 值)
        } else {
            nextWorkDay = date.plusDays(1);
        }
        return nextWorkDay;
    }
}
