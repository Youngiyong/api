package com.test.api.util;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDay {

    public List<String> getThreeDay() throws Exception {
        List<String> dayList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        for(int i=0; i<3; i++){
            cal.add(Calendar.DATE, i);
            dayList.add(getDateDay(sdf.format(cal.getTime())));
            cal.add(Calendar.DATE, -i);
        }

        return dayList;
    }

    public String getToday(){
        String day = "" ;
        Date nDate = new Date();
        Calendar cal = Calendar.getInstance() ;
        cal.setTime(nDate);

        int dayNum = cal.get(Calendar.DAY_OF_WEEK) ;

        switch(dayNum){
            case 1:
                day = "Sunday";
                break ;
            case 2:
                day = "Monday";
                break ;
            case 3:
                day = "Tuesday";
                break ;
            case 4:
                day = "Wednesday";
                break ;
            case 5:
                day = "Thursday";
                break ;
            case 6:
                day = "Friday";
                break ;
            case 7:
                day = "Saturday";
                break ;

        }
        return day;
    }

    public String getDateDay(String date) throws Exception {

        String day = "" ;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd") ;
        Date nDate = dateFormat.parse(date) ;

        Calendar cal = Calendar.getInstance() ;
        cal.setTime(nDate);

        int dayNum = cal.get(Calendar.DAY_OF_WEEK) ;

        switch(dayNum){
            case 1:
                day = "Sunday";
                break ;
            case 2:
                day = "Monday";
                break ;
            case 3:
                day = "Tuesday";
                break ;
            case 4:
                day = "Wednesday";
                break ;
            case 5:
                day = "Thursday";
                break ;
            case 6:
                day = "Friday";
                break ;
            case 7:
                day = "Saturday";
                break ;

        }



        return day ;
    }


}
