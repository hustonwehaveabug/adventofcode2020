package org.example.task3;

import org.example.utils.FileReader;

public class Part2 {

    private static final char TREE = '#';

    public static void main(String[] args) {
        char[][] input = FileReader.readFileAsArray("task3-input.txt");
        long numberOfTrees1 = checkForTree(input, 1, 1);
        long numberOfTrees2 = checkForTree(input, 3, 1);
        long numberOfTrees3 = checkForTree(input, 5, 1);
        long numberOfTrees4 = checkForTree(input, 7, 1);
        long numberOfTrees5 = checkForTree(input, 1, 2);
        System.out.println(numberOfTrees1);
        System.out.println(numberOfTrees2);
        System.out.println(numberOfTrees3);
        System.out.println(numberOfTrees4);
        System.out.println(numberOfTrees5);
        long multiply = numberOfTrees1 * numberOfTrees2 * numberOfTrees3 * numberOfTrees4 * numberOfTrees5;
        System.out.println("Trees multiply: " + multiply);
    }

    private static int checkForTree(char[][] strings, int moveRight, int moveDown) {
        int numberOfTrees = 0;
        int width = strings[0].length;
        int horizontalPosition = 0;
        for (int i = moveDown; i < strings.length; i += moveDown) {
            horizontalPosition = (horizontalPosition + moveRight) % width;
            if(strings[i][horizontalPosition] == TREE) {
                numberOfTrees++;
            }
        }
        return numberOfTrees;
    }
}
