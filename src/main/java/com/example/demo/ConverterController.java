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

    @GetMapping("/converter")
    public String year(@RequestParam(required = true, defaultValue = "") String input) {
        return converter.converter(input);
    }
}