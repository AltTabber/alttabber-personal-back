package com.alttabber.trunk;

import com.alttabber.data.WeekData;

import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1992, 10, 19, 8, 0, 0);
        calendar.add(Calendar.YEAR, 70);
        Date finalDate = new Date(calendar.getTime().getTime());
        Date currentDate = new Date();
        calendar.set(1992, 10, 19, 8, 0, 0);
        System.out.println(calendar.getTime());
        while(calendar.getTime().before(finalDate)){
            WeekData week = new WeekData();
            week.setYear(calendar.get(Calendar.YEAR));
            week.setDateStart(calendar.getTime());
            week.setPassed(calendar.getTime().before(currentDate));
            calendar.add(Calendar.DATE, 7);
            week.setDateEnd(calendar.getTime());
            week.setContainsData(false);
            System.out.println(week);
        }
    }
}
