package com.alttabber.data;

import java.util.Date;

public class WeekData {

    private String id;
    private Date dateStart;
    private Date dateEnd;
    private Integer year;
    private boolean isPassed;
    private boolean isContainsData;

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    public boolean isContainsData() {
        return isContainsData;
    }

    public void setContainsData(boolean containsData) {
        isContainsData = containsData;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
