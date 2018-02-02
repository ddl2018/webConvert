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
    public String converter(String input) {
        if (input.isEmpty() || input == null) {
            return "Null input";
        }
        String result = input;
        Pattern pYear = Pattern.compile("^\\d{4}$");
        Pattern pQuarter = Pattern.compile("^Q-\\d{4}-[1|2|3|4]$");
        Pattern pSeason = Pattern.compile("^SWS-\\d{4}-(04|10)$");
        Pattern pMonth = Pattern.compile("^M-\\d{4}-(0[1-9]|10|11|12$)");

        Matcher mYear = pYear.matcher(result);
        Matcher mQuater = pQuarter.matcher(result);
        Matcher mSeason = pSeason.matcher(result);
        Matcher mMonth = pMonth.matcher(result);

        if (mYear.matches()) {
            return convertYear(result);
        } else if (mQuater.matches()) {
            return convertQuarter(result);
        } else if (mSeason.matches()) {
            return convertSeason(result);
        } else if (mMonth.matches()) {
            return convertMonth(result);
        } else {
            return "Invalid input";
        }
    }

    private String convertYear(String year) {
        String result = year;
        return result;
    }

    private String convertQuarter(String quater) {
        String tmp = quater;
        String result = "";
        String[] parts = tmp.split("-");
        result = parts[0] + parts[2] + "-" + parts[1].substring(2);
        return result;
    }

    private String convertSeason(String searson) {
        String tmp = searson;
        String result = "";
        String[] parts = tmp.split("-");
        if (parts[2].equals("04")) {
            result = "Sum" + "-" + parts[1].substring(2);
        } else if (parts[2].equals("10")) {
            result = "Win" + "-" + parts[1].substring(2) + "/" + (Integer.valueOf(parts[1].substring(2)) + 1);
        }
        return result;
    }

    private String convertMonth(String month) {
        String result = "";
        String tmp = month;
        String[] parts = tmp.split("-");
        result = matchMonthWithNumber(parts[2]) + "-" + parts[1];
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
            monthWith3Abbr = "Mar";
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
