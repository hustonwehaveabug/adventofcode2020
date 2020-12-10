package utils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public static List<Integer> readFile(String path) {
        List<Integer> result = new ArrayList<>();

        try (Scanner scanner = new Scanner(getFileFromResource(path))) {
            while (scanner.hasNextLine()) {
                result.add(Integer.parseInt(scanner.nextLine()));
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
