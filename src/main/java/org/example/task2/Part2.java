package org.example.task2;

import org.example.utils.FileReader;

import java.util.List;

public class Part2 {

    public static void main(String[] args) {

        List<String> input = FileReader.readFileAsStrings("task2-input.txt");
        long validPasswordsCount = input.stream()
                .map(s -> s.trim().split("\\s+"))
                .map(Part2::validatePass)
                .filter(b -> b)
                .count();
        System.out.println("Valid passwords: " + validPasswordsCount);
    }

    private static boolean validatePass(String[] split) {
        String[] positions = split[0].split("-");
        int position1 = Integer.parseInt(positions[0]);
        int position2 = Integer.parseInt(positions[1]);
        char letterToCheck = split[1].substring(0, 1).toCharArray()[0];
        char[] pass = split[2].toCharArray();
        char char1 = pass[position1 - 1];
        char char2 = pass[position2 - 1];
        return (char1 == letterToCheck || char2 == letterToCheck) && char1 != char2;
    }
}
