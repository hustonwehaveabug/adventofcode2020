package org.example.task3;

import org.example.utils.FileReader;

public class Part1 {

    private static final char TREE = '#';
    private static final int MOVE_RIGHT = 3;

    public static void main(String[] args) {
        char[][] input = FileReader.readFileAsArray("task3-input.txt");
        int numberOfTrees = checkForTree(input);
        System.out.println("Trees: " + numberOfTrees);
    }

    private static int checkForTree(char[][] strings) {
        int numberOfTrees = 0;
        int width = strings[0].length;
        int horizontalPsition = 0;
        for (int i = 1; i < strings.length; i++) {
            horizontalPsition = (horizontalPsition + MOVE_RIGHT) % width;
            if(strings[i][horizontalPsition] == TREE) {
                numberOfTrees++;
            }
        }
        return numberOfTrees;
    }
}
