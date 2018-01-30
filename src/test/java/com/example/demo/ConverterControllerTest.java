package com.example.demo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ConverterController.class, secure = false)
@ContextConfiguration
public class ConverterControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MyConverter converter;

    @Test
    public void convertYear() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/year?inputyear=2018");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse());
        String expected = "2018";
        assertThat(expected.equals(result));
    }

    @Test
    public void convertQuarter() throws Exception {
    	RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/quarter?inputquarter=Q-2017-4");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse());
        String expected = "Q4-17";
        assertThat(expected.equals(result));
    }

    @Test
    public void convertSeason() throws Exception{
    	RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/season?inputyear=SWS-2018-04");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse());
        String expected = "Sum-18";
        assertThat(expected.equals(result));
    }

    @Test
    public void convertMonth() throws Exception{
    	RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/month?inputmonth=M-2018-01");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse());
        String expected = "Jan-2018";
        assertThat(expected.equals(result));
    }
}