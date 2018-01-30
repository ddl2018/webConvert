package com.example.demo;

import org.assertj.core.api.AbstractStandardSoftAssertions;
import org.junit.Test;

import static org.junit.Assert.assertFalse;


public class MyConverterTest extends AbstractStandardSoftAssertions {
    MyConverter testObj = new MyConverter();


    @Test
    public void convertYear() {
        assertThat(testObj.getClass().getName().equals("MyConverter"));
        assertThat(testObj.convertYear("2018").equals("2018"));
        String result = testObj.convertYear("2008");
        assertThat(result.equals("2008"));
        assertFalse(result.equals("08"));
    }

    @Test
    public void convertQuarter() {
        assertThat(testObj.convertQuarter("Q-2018-1").equals("Q1-18"));
        assertThat(testObj.convertQuarter("Q-2017-4").equals("Q4-17"));
        assertThat(testObj.convertQuarter("Q-2017-3").equals("Q3-17"));
        assertThat(testObj.convertQuarter("Q-2017-2").equals("Q2-17"));
        assertFalse(testObj.convertQuarter("Q-2017-5").equals("Q2-17"));
    }

    @Test
    public void convertSeason() {
        assertThat(testObj.convertSeason("SWS-2017-04").equals("Sum-17"));
        assertFalse(testObj.convertSeason("SWS-2017-4").equals("Sum-17"));
        assertThat(testObj.convertSeason("SWS-2017-10").equals("Win-17/18"));
        assertFalse(testObj.convertSeason("SWS-2017-11").equals("Win-17/18"));
        assertFalse(testObj.convertSeason("SWS-2017-11").equals("Sum-17"));

    }

    @Test
    public void convertMonth() {
        assertThat(testObj.convertMonth("M-2018-01").equals("Jan-2018"));
        assertThat(testObj.convertMonth("M-2017-02").equals("Feb-2017"));
        assertFalse(testObj.convertMonth("M-2018-1").equals("Jan-2018"));
        assertFalse(testObj.convertMonth("M-2018-13").equals("Jan-2018"));
    }
}