package com.oneline.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class TestDateFormat {

    public static void main(String[] args) {
//        date2Describe("2019/9/19 12:57:12");
        dateToWeek("2019/9/19 12:57:12");
    }

    public static void dateToWeek(String rawDate) {
        String resultDate = "";
        String[] splitTimes = rawDate.split(" ");
        String datetime = splitTimes[0];
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String[] weekDays = {"星期日 ", "星期一 ", "星期二 ", "星期三 ", "星期四 ", "星期五 ", "星期六 "};
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        Date datet = null;
        try {
            datet = format.parse(datetime);
            cal.setTime(datet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0)
            w = 0;
        resultDate = weekDays[w] + splitTimes[1].substring(0, 5);
        System.out.println(resultDate);
    }

    public static void date2Describe(String rawDate) {
        String resultDate = "";
        String WeekDay = "";
        String[] splitTimes = rawDate.split(" ");
        String time = splitTimes[0];
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date date = null;
        try {
            date = format.parse(time);
            Instant instant = date.toInstant();
            ZoneId zoneId = ZoneId.systemDefault();
            LocalDate localDate = instant.atZone(zoneId).toLocalDate();
            DayOfWeek day = localDate.getDayOfWeek();
            switch (day) {
                case MONDAY:
                    WeekDay = "星期一 ";
                    break;
                case FRIDAY:
                    WeekDay = "星期五 ";
                    break;
                case SATURDAY:
                    WeekDay = "星期六 ";
                    break;
                case SUNDAY:
                    WeekDay = "星期日 ";
                    break;
                case THURSDAY:
                    WeekDay = "星期四 ";
                    break;
                case TUESDAY:
                    WeekDay = "星期二 ";
                    break;
                case WEDNESDAY:
                    WeekDay = "星期三 ";
                    break;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String rawTime = splitTimes[1];
        System.out.println(WeekDay + rawTime.substring(0, 5));
    }
}
