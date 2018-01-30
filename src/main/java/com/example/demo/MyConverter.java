package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created on @ 30.01.18
 *
 * @author 杨敏
 * email ddl-15 at outlook.com
 **/
@Component
public class MyConverter {
    public String convertYear(String year) {
        if (year.isEmpty() || year == null) {
            return "Wrong input";
        }
        String result = year;
        return result;
    }

    public String convertQuarter(String quater) {
        if (quater.isEmpty() || quater == null) {
            return "Wrong input";
        }
        String result = "";
        String tmp = quater;
        Pattern pattern = Pattern.compile("^Q-\\d{4}-[1|2|3|4]$");
        Matcher matcher = pattern.matcher(tmp);
        if (matcher.matches()) {
            String[] parts = tmp.split("-");
            result = parts[0] + parts[2] + "-" + parts[1].substring(2);
        }
        return result;
    }

    public String convertSeason(String searson) {
        if (searson.isEmpty() || searson == null) {
            return "Wrong input";
        }
        String result = "";
        String tmp = searson;
        Pattern pattern = Pattern.compile("^SWS-\\d{4}-(04|10)$");
        Matcher matcher = pattern.matcher(tmp);
        if (matcher.matches()) {
            String[] parts = tmp.split("-");
            if (parts[2] == "04") {
                result = "Sum" + parts[1].substring(2);
            } else {
                result = "Win" + parts[1].substring(2) + "/" + (Integer.valueOf(parts[1].substring(2)) + 1);
            }
        }
        return result;
    }

    public String convertMonth(String month) {
        if (month.isEmpty() || month == null) {
            return "Wrong input";
        }
        String result = "";
        String tmp = month;
        Pattern pattern = Pattern.compile("^M-\\d{4}-([1-9]|[0-1][1-2])$");
        Matcher matcher = pattern.matcher(tmp);
        if (matcher.matches()) {
            String[] parts = tmp.split("-");
            result = matchMonthWithNumber(parts[2]) + parts[1];
        }
        return result;
    }

    private String matchMonthWithNumber(String number) {
        String monthWith3Abbr = "";
        if (Integer.valueOf(number) == 1) {
            monthWith3Abbr = "Jan";
            return monthWith3Abbr;
        }
        if (Integer.valueOf(number) == 2) {
            monthWith3Abbr = "Feb";
            return monthWith3Abbr;
        }
        if (Integer.valueOf(number) == 3) {
            monthWith3Abbr = "Mat";
            return monthWith3Abbr;
        }
        if (Integer.valueOf(number) == 4) {
            monthWith3Abbr = "Apr";
            return monthWith3Abbr;
        }
        if (Integer.valueOf(number) == 5) {
            monthWith3Abbr = "May";
            return monthWith3Abbr;
        }
        if (Integer.valueOf(number) == 6) {
            monthWith3Abbr = "Jun";
            return monthWith3Abbr;
        }
        if (Integer.valueOf(number) == 7) {
            monthWith3Abbr = "Jul";
            return monthWith3Abbr;
        }
        if (Integer.valueOf(number) == 8) {
            monthWith3Abbr = "Aug";
            return monthWith3Abbr;
        }
        if (Integer.valueOf(number) == 9) {
            monthWith3Abbr = "Sep";
            return monthWith3Abbr;
        }
        if (Integer.valueOf(number) == 10) {
            monthWith3Abbr = "Oct";
            return monthWith3Abbr;
        }
        if (Integer.valueOf(number) == 11) {
            monthWith3Abbr = "Nov";
            return monthWith3Abbr;
        }
        if (Integer.valueOf(number) == 12) {
            monthWith3Abbr = "Dec";
            return monthWith3Abbr;
        }
        return monthWith3Abbr;
    }
}
