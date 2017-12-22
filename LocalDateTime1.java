package com.coderpwh.time;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * Created by coderpwh on 2017/12/22.
 */
public class LocalDateTime1 {

    public static void main(String[] args) {

        // 2017-12-22 星期五
        LocalDateTime  sylvester = LocalDateTime.of(2017, Month.DECEMBER,22,8,59,59);

        DayOfWeek dayOfWeek = sylvester.getDayOfWeek();

        // 周五
        System.out.println(dayOfWeek);

        Month month = sylvester.getMonth();

        // 12月
        System.out.println(month);

        long minuteofDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);

        // 539
        System.out.println(minuteofDay);

        Instant instant = sylvester
                .atZone(ZoneId.systemDefault())
                .toInstant();

         Date legacyDate = Date.from(instant);

        // Fri Dec 22 08:59:59 CST 2017
        System.out.println(legacyDate);


        DateTimeFormatter formatter =
                DateTimeFormatter
                        .ofPattern("MMM dd, yyyy - HH:mm");

        LocalDateTime parsed = LocalDateTime.parse("Dec 22, 2017 - 10:20", formatter);
        String string = parsed.format(formatter);

        // 12 22, 2017 - 10:20
        System.out.println(string);





    }
}
