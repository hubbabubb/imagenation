package com.codecool.imagenation.logic;

import com.codecool.imagenation.data.Database;
import com.codecool.imagenation.data.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ThemeConverter {

    @Autowired
    private Database database;

    private String text;

    public Theme convertToTheme(String text) {
        this.text = text;

        Theme theme = new Theme();
        List<String> relevantWords = getRelevantWords();

        for (int i = 0; i < relevantWords.size(); i++) {
            String currentWord = relevantWords.get(i);
            String wordBefore = "";
            String wordAfter = "";
            if (i - 1 > 0) {
                wordBefore = relevantWords.get(i-1);
            }
            if (i+1 < relevantWords.size()) {
                wordAfter = relevantWords.get(i+1);
            }

            if (database.getOBJECT().containsKey(currentWord)) {
                theme.setObject(currentWord);
                theme.setObjectFile(database.getOBJECT().get(currentWord));
            }

            if (database.getCOLOR().containsKey(currentWord)) {
                if (Arrays.asList(database.getBORDER()).contains(wordBefore) ||
                        Arrays.asList(database.getBORDER()).contains(wordAfter)) {
                    theme.setBorderColor(database.getCOLOR().get(currentWord));
                    theme.setBorderWidth(1.5f);
                } else {
                    theme.setColor(database.getCOLOR().get(currentWord));
                }
            }

            if (database.getSIZE().containsKey(currentWord)) {
                theme.setSize(database.getSIZE().get(currentWord));
            }

            if (database.getBORDER_SIZE().containsKey(currentWord)) {
                theme.setBorderWidth(database.getBORDER_SIZE().get(currentWord));
            }
        }

        return theme;
    }

    private List<String> getRelevantWords() {
        String[] words = getWords();
        List<String> relevantWords = new ArrayList<>();

        for (String word : words) {
            if (isRelevant(word)) {
                relevantWords.add(word);
            }
        }
        return relevantWords;
    }

    private String[] getWords() {
        String[] words = this.text.split("\\s+");

        for (int i = 0; i < words.length; i++) {
            String nonWordCharacter = "[^\\w]";
            words[i] = words[i].replaceAll(nonWordCharacter, "");
            words[i] = words[i].toLowerCase();
        }

        return words;
    }

    private boolean isRelevant(String word) {
        return database.getOBJECT().containsKey(word) ||
                database.getCOLOR().containsKey(word) ||
                database.getSIZE().containsKey(word) ||
                Arrays.asList(database.getBORDER()).contains(word) ||
                database.getBORDER_SIZE().containsKey(word);

    }

}
