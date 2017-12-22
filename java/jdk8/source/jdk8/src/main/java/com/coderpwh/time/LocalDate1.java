package com.coderpwh.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * Created by coderpwh on 2017/12/21.
 */
public class LocalDate1 {

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();

        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);

        LocalDate yesterday = tomorrow.minusDays(2);

        System.out.println("今天:"+today);
        System.out.println("明天:"+tomorrow);
        System.out.println("昨天:"+yesterday);

        LocalDate independenceDay = LocalDate.of(2017, Month.DECEMBER,21);

        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();

        System.out.println(dayOfWeek);


        DateTimeFormatter  germanFormatter = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.MEDIUM)
                .withLocale(Locale.CANADA);
         LocalDate  xmas = LocalDate.parse("24.12.2014",germanFormatter);
        System.out.println(xmas);




    }
}
