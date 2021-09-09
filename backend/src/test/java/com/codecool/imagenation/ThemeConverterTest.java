package com.codecool.imagenation;

import com.codecool.imagenation.data.Database;
import com.codecool.imagenation.logic.Theme;
import com.codecool.imagenation.logic.ThemeConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class ThemeConverterTest {

    @Autowired
    private ThemeConverter themeConverter;

    @Autowired
    private Database database;

    @Test
    public void whenGivenTextRedDog_ShouldReturnRedDogTheme() {
        Theme red_duck = themeConverter.convertToTheme("Red dog");

        Assertions.assertEquals(red_duck.getColor(), database.getCOLOR().get("red"));
        Assertions.assertTrue(red_duck.getAllObjects().containsKey("dog"));
    }

    @Test
    public void whenGivenTextRedDogWithBorderColorYellow_ShouldReturnRedDogYellowBorderTheme() {
        Theme red_duck = themeConverter.convertToTheme("Red dog with yellow border");

        Assertions.assertEquals(red_duck.getBorderColor(), database.getCOLOR().get("yellow"));
    }

    @Test
    public void whenGivenTextThickBorder_ShouldReturnThickBorderThemeWithDefaultObject() {
        Theme thick_border_on_circle = themeConverter.convertToTheme("Thick border!");

        Assertions.assertEquals(thick_border_on_circle.getBorderWidth(), database.getBORDER_SIZE().get("thick"));
    }

    @Test
    public void whenGivenWordBird_ShouldReturnKiwiBirdAndEarlyBirds() {
        Theme birdTheme = themeConverter.convertToTheme("bird");

        Set<String> resultKeys = new HashSet<>();
        resultKeys.add("kiwi-bird");
        resultKeys.add("earlybirds");

        Assertions.assertEquals(birdTheme.getAllObjects().keySet(), resultKeys);
    }

}
