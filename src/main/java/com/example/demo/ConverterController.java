package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

/**
 * Created on @ 30.01.18
 *
 * @author 杨敏
 * email ddl-15 at outlook.com
 **/
@RestController
@EnableAutoConfiguration
public class ConverterController {
    @Autowired
    private MyConverter converter;

    @GetMapping("/year/{inputyear}")
    public String year(@PathVariable String inputYear) {
        return converter.convertYear(inputYear);
    }

    @GetMapping("/quarter/{inputquarter}")
    public String quar(@PathVariable String inputQuar) {
        return converter.convertYear(inputQuar);
    }

    @GetMapping("/season/{inputseason}")
    public String season(@PathVariable String inputSeason) {
        return converter.convertYear(inputSeason);
    }

    @GetMapping("/month/{inputmonth}")
    public String month(@PathVariable String inputMonth) {
        return converter.convertYear(inputMonth);
    }
}