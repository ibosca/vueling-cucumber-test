package com.lasalle.automation.vueling.web.domain;

import java.util.Calendar;
import java.util.Date;

public class Daterize {

    public static Date fromString(String dateKey) {

        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_YEAR, getNumberOfDays(dateKey));

        return calendar.getTime();
    }

    public static int getNumberOfDays(String dateKey) {
        switch (dateKey){
            case "NEXT_WEEK":
                return 7;
            case "TWO_WEEKS_FROM_NOW":
                return 14;
            case "THREE_WEEKS_FROM_NOW":
                return 21;
        }

        return 0;
    }
}
