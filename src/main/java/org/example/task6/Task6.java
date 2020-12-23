package org.example.task6;

import org.example.Validator;
import org.example.utils.FileReader;

public class Task6 {

    public static void main(String[] args) {

        Validator validator = new Day6Validator(FileReader.readFileAsStrings("task6-input.txt"));
        System.out.println("Day 6 part 1 answer: " + validator.validatePartOne());
        System.out.println("Day 6 part 2 answer: " + validator.validatePartTwo());
    }
}
