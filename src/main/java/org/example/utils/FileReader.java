package org.example.utils;

import javax.sound.sampled.Line;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileReader {

    private FileReader() {
        throw new IllegalStateException("Util class");
    }

    public static char[][] readFileAsArray(String path) {
        List<char[]> lines = new ArrayList<>(400);
        try (Scanner scanner = new Scanner(getFileFromResource(path))) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine().toCharArray());
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return new char[0][0];
        }
        char[][] result = new char[lines.size()][lines.get(0).length];
        int i = 0;
        for(char[] line : lines) {
            for (int j = 0; j < line.length; j++) {
                result[i][j] = line[j];
            }
            i++;
        }
        return result;
    }

    public static List<Integer> readFileAsIntegers(String path) {
        List<String> strings = readFileAsStrings(path);
        return strings.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<String> readFileAsStrings(String path) {
        List<String> result = new ArrayList<>();

        try (Scanner scanner = new Scanner(getFileFromResource(path))) {
            while (scanner.hasNextLine()) {
                result.add(scanner.nextLine());
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
        return result;
    }

    private static File getFileFromResource(String fileName) throws URISyntaxException {

        ClassLoader classLoader = FileReader.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return new File(resource.toURI());
        }

    }
}
