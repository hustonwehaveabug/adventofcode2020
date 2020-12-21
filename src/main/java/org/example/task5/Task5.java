package org.example.task5;

import org.example.Validator;
import org.example.utils.FileReader;

import java.util.List;

public class Task5 {

    public static void main(String[] args) {

        Validator validator = new Day5Validator(FileReader.readFileAsStrings("task5-input.txt"));
        System.out.println("Day 5 part 1 answer: " + validator.validatePartOne());
        System.out.println("Day 5 part 2 answer: " + validator.validatePartTwo());
    }
}
