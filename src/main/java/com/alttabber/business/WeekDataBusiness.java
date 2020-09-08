package com.alttabber.business;

import com.alttabber.data.BlogDto;
import com.alttabber.data.WeekData;
import com.alttabber.repository.WeekDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class WeekDataBusiness {

    @Autowired
    WeekDataRepository weekDataRepository;


    public List<WeekData> generateWeekData() {
        List<WeekData> weekDataList = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.set(1992, 10, 19, 8, 0, 0);
        calendar.add(Calendar.YEAR, 50);
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

            weekDataRepository.insert(week);

            weekDataList.add(week);
        }

        return weekDataList;

    }

    public List<WeekData> getFullList() {
        return weekDataRepository.findAll(Sort.by("dateStart"));
    }
}
