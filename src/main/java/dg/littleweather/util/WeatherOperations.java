package dg.littleweather.util;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.TimeZone;

@Component
public class WeatherOperations {

    //method to convert unix value in the hourly and daily fields into a date with better format
    public static String unixToDate(long unix, String zone, int offset){
        //get date by unix seconds
        Date date = new Date(unix*1000L);
        //get time zone
        String timeZone = TimeZone.getTimeZone(zone).getID().toString();
        String[] dateAndTime = date.toString().split(" ");
        //find utc by timezone offset
        int timezoneOffset = offset;
        timezoneOffset /= 3600;
        String java_offset = offsetToUtc(timezoneOffset);

        // set formatted date and hour
        String date_str = dateAndTime[0] + " " + dateAndTime[1] + " " + dateAndTime[2] + " " + dateAndTime[5] + " " + dateAndTime[3] + " " + timeZone + java_offset;
        return date_str;
    }

    //method to convert unix to date
    public static String unixToDate(long unix){
        Date date = new Date(unix*1000L);
        String[] dateAndTime = date.toString().split(" ");
        String date_str = dateAndTime[1] + " " + dateAndTime[2] + " " + dateAndTime[5];
        return date_str;
    }

    private static String offsetToUtc(int offset){
        String java_offset = "";
        //check -0X:00 condition
        if(offset < 0 && offset > -10){
            java_offset = "-0".concat(String.valueOf(Math.abs(offset)) + ":00");
        }
        //check -XX:00 condition
        else if (offset < 0 && offset <= -10) {
            java_offset = "-".concat(String.valueOf(Math.abs(offset)) + ":00");
        }
        //check +0X:00 condition
        else if(offset >= 0 && offset < 10){
            java_offset = "+0"+offset+":00";
        }
        //check +XX:00 condition
        else if(offset >= 0 && offset >= 10){
            java_offset = "+" +offset+":00";
        }
        return java_offset;
    }

}
