package com.alttabber.api;

import com.alttabber.business.WeekDataBusiness;
import com.alttabber.data.BlogDto;
import com.alttabber.data.WeekData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeekDataController {

    @Autowired
    WeekDataBusiness weekDataBusiness;

    @GetMapping("/admin/weeks/create")
    public List<WeekData> createWeekData(){
        return weekDataBusiness.generateWeekData();
    }

    @GetMapping("/weeks/list")
    public List<WeekData> getWeekData(){
        return weekDataBusiness.getFullList();
    }

}
