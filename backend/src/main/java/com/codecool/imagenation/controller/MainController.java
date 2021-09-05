package com.codecool.imagenation.controller;

import com.codecool.imagenation.logic.ThemeConverter;
import com.codecool.imagenation.data.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private ThemeConverter themeConverter;

    @GetMapping(path = "/api/convert")
    public Theme getTheme(@RequestBody String text) {
        return themeConverter.convertToTheme(text);
    }
}
