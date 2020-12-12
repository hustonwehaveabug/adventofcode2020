package org.example.task2;

import org.example.utils.FileReader;

import java.util.List;
import java.util.stream.Collectors;

public class Part1 {

    public static void main(String[] args) {

        List<String> input = FileReader.readFileAsStrings("task2-input.txt");
        long validPasswordsCount = input.stream()
                .map(s -> s.trim().split("\\s+"))
                .map(Part1::validatePass)
                .filter(b -> b)
                .count();
        System.out.println("Valid passwords: " + validPasswordsCount);
    }

    private static boolean validatePass(String[] split) {
        String[] range = split[0].split("-");
        int rangeFrom = Integer.parseInt(range[0]);
        int rangeTo = Integer.parseInt(range[1]);
        char letterToCheck = split[1].substring(0, 1).toCharArray()[0];
        char[] pass = split[2].toCharArray();
        int count = 0;
        for (char letter : pass) {
            if(letter == letterToCheck) {
                count++;
            }
        }
        return count >= rangeFrom && count <= rangeTo;
    }
}
