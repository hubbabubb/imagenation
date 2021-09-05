package com.codecool.imagenation.data;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Database {

    private final static Map<String, String> OBJECT = createObjectMap();

    private final static String[] COLOR_EXPRESSIONS = new String[]{"colour", "fill", "color", "colored", "filled", "dye", "coloring", "filling"};

    private final static Map<String, String> COLOR = Map.ofEntries(
            Map.entry("red", "#e76f51"),
            Map.entry("yellow", "#ffba08"),
            Map.entry("blue", "#0077b6"),
            Map.entry("brown", "#7f5539"),
            Map.entry("orange", "#fb8500"),
            Map.entry("green", "#38b000"),
            Map.entry("violet", "#7b2cbf"),
            Map.entry("black", "#03071e"),
            Map.entry("pink", "#c9184a"),
            Map.entry("white", "#ffffff"),
            Map.entry("dandelion", "#fcbf49"),
            Map.entry("scarlet", "#d90429"),
            Map.entry("indigo", "#003566"),
            Map.entry("gray", "#8d99ae"));

    private final static Map<String, Integer> SIZE = Map.ofEntries(
            Map.entry("small", 100),
            Map.entry("little", 80),
            Map.entry("tiny", 50),
            Map.entry("medium", 200),
            Map.entry("regular", 200),
            Map.entry("normal", 200),
            Map.entry("big", 300),
            Map.entry("giant", 400),
            Map.entry("huge", 500),
            Map.entry("large", 300),
            Map.entry("massive", 500),
            Map.entry("fat", 500));

    private final static String[] BORDER = new String[]{"outline", "border", "stroke", "contour"};

    private final static Map<String, Float> BORDER_SIZE = Map.ofEntries(
            Map.entry("thin", 0.5f),
            Map.entry("slim", 1f),
            Map.entry("normal", 2f),
            Map.entry("medium", 2f),
            Map.entry("regular", 1.5f),
            Map.entry("thick", 3f),
            Map.entry("crass", 3f));


    private static Map<String, String> createObjectMap() {
        Map<String, String> results = new HashMap<>();
        List<Path> files = null;
        try {
            files = listFilesUsingFilesList("src/main/resources/static/images/fontawesome");
            for (Path path : files) {
                if (path.toFile().isFile() && FilenameUtils.getExtension(path.toFile().toString()).equals("svg")) {
                    String object = FilenameUtils.removeExtension(path.getFileName().toString());
                    String imagePath = path.toAbsolutePath().toString().split("static/images/")[1];
                    results.put(object, imagePath);
                }
            }
        } catch (IOException e) {
            System.err.println("Err: " + e);
        }

        return results;
    }

    private static List<Path> listFilesUsingFilesList(String dir) throws IOException {
        int DEPTH = 2;
        try (Stream<Path> stream = Files.walk(Paths.get(dir), DEPTH)) {
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .collect(Collectors.toList());
        }
    }

    private static boolean isSvg(File file) {
        return FilenameUtils.getExtension(file.getName()).toLowerCase().equals("svg");
    }

    public Map<String, String> getOBJECT() {
        return OBJECT;
    }

    public Map<String, String> getCOLOR() {
        return COLOR;
    }

    public Map<String, Integer> getSIZE() {
        return SIZE;
    }

    public String[] getBORDER() {
        return BORDER;
    }

    public Map<String, Float> getBORDER_SIZE() {
        return BORDER_SIZE;
    }

    public String[] getCOLOR_EXPRESSIONS() {
        return COLOR_EXPRESSIONS;
    }
}
