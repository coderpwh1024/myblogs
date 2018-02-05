package com.coderpwh.effective_java.chapter1.five;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author coderpwh
 * @Date: 2018/1/30.
 * @Description:
 */
public class Person {

    private final Date birthDate;

    public Person(Date birthDate) {
        this.birthDate = birthDate;
    }


    public boolean isBabyBoomer() {
        Calendar gmtcal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtcal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomStart = gmtcal.getTime();
        gmtcal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomEnd = gmtcal.getTime();
        return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) < 0;
    }


}
