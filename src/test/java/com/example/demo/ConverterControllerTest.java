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

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import static junit.framework.TestCase.assertTrue;

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
                "/converter?input=2018");
        RequestBuilder requestBuilder1 = MockMvcRequestBuilders.get(
                "/converter?input=SWS-2018-04");
//        RequestBuilder requestBuilder2 = MockMvcRequestBuilders.get(
//                "/converter?input=SWS-2018-10");
//        RequestBuilder requestBuilder3 = MockMvcRequestBuilders.get(
//                "/converter?input=Q-2018-2");
//        RequestBuilder requestBuilder4 = MockMvcRequestBuilders.get(
//                "/converter?input=M-2018-03");
        String expected = "2018";
        String expected1 = "Sum-18";
        String expected2 = "Win-18/19";
        String expected3 = "Q2-18";
        String expected4 = "Mar-2018";
        boolean result = mockMvc.perform(requestBuilder).andReturn().getResponse().getContentAsString().equals(expected);
        System.out.println(mockMvc.perform(requestBuilder).andReturn().getResponse().getContentAsString() + "MINMIN");
//        MvcResult result = (MvcResult) mockMvc.perform(requestBuilder1).andExpect(status().isOk())
//                .andExpect(content().string(expected1));
//        System.out.println(result + " MINMIN");
//        result = mockMvc.perform(requestBuilder2).andReturn();
//        assertTrue(expected2.equals(result.getRequest().getParameter("input")));
//
//        result = mockMvc.perform(requestBuilder3).andReturn();
//        assertTrue(expected3.equals(result.getRequest().getParameter("input")));
//
//        result = mockMvc.perform(requestBuilder4).andReturn();
//        assertTrue(expected4.equals(result.getRequest().getParameter("input")));
    }
}