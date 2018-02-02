package com.example.demo;

import org.assertj.core.api.AbstractStandardSoftAssertions;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class MyConverterTest extends AbstractStandardSoftAssertions {
    MyConverter testObj = new MyConverter();

    @Test
    public void testMyconverter() {
        assertThat(testObj.getClass().getName().equals("MyConverter"));
        assertThat(testObj.converter("2018").equals("2018"));
        String result = testObj.converter("2008");
        assertThat(result.equals("2008"));
        assertTrue(result.endsWith("2008"));
        assertFalse(result.equals("08"));

        assertThat(testObj.converter("Q-2018-1").equals("Q1-18"));
        assertTrue(testObj.converter("Q-2017-4").equals("Q4-17"));
        assertTrue(testObj.converter("Q-2017-3").equals("Q3-17"));
        assertTrue(testObj.converter("Q-2017-2").equals("Q2-17"));
        assertTrue(testObj.converter("Q-2017-2").equals("Q2-17"));
        assertFalse(testObj.converter("Q-2017-02").equals("Q2-17"));
        assertFalse(testObj.converter("Q-2017-5").equals("Q2-17"));

        assertTrue(testObj.converter("SWS-2017-04").equals("Sum-17"));
        assertFalse(testObj.converter("SWS-2017-4").equals("Sum-17"));
        assertFalse(testObj.converter("SWS-2017-40").equals("Sum-17"));
        assertThat(testObj.converter("SWS-2017-10").equals("Win-17/18"));
        assertFalse(testObj.converter("SWS-2017-01").equals("Win-17/18"));
        assertFalse(testObj.converter("SWS-2017-11").equals("Win-17/18"));
        assertTrue(testObj.converter("SWS-2017-10").equals("Win-17/18"));
        assertFalse(testObj.converter("SWS-2017-11").equals("Sum-17"));

        assertThat(testObj.converter("M-2018-01").equals("Jan-2018"));
        assertThat(testObj.converter("M-2017-02").equals("Feb-2017"));
        assertFalse(testObj.converter("M-2018-1").equals("Jan-2018"));
        assertTrue(testObj.converter("M-2018-03").equals("Mar-2018"));
        assertFalse(testObj.converter("M-2018-3").equals("Mar-2018"));
        assertFalse(testObj.converter("M-2018-00").equals("Mar-2018"));
        assertFalse(testObj.converter("M-2018-13").equals("Mar-2018"));
        assertFalse(testObj.converter("M-2018-13").equals("Jan-2018"));
    }
}