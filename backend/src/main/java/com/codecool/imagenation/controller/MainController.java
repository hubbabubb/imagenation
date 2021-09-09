package com.codecool.imagenation.controller;

import com.codecool.imagenation.logic.Theme;
import com.codecool.imagenation.logic.ThemeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin({"http://localhost:3000"})
@RestController
public class MainController {

    @Autowired
    private ThemeConverter themeConverter;

    @PostMapping(path = "/api/convert")
    public Theme getTheme(@RequestBody String text) {
        return themeConverter.convertToTheme(text);
    }
}
