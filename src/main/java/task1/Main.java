package task1;

import utils.FileReader;

import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int sum = 2020;

        List<Integer> input = FileReader.readFile("task1-input.txt");

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < input.size(); i++) {
            if (hashSet.contains(sum - input.get(i))) {
                Integer firstNumber = input.get(i);
                int secondNumber = sum - firstNumber;
                System.out.println(firstNumber + " + " + secondNumber + " = " + sum);
                int multiply = firstNumber * secondNumber;
                System.out.println(firstNumber + " * " + secondNumber + " = " + multiply);
            }
            hashSet.add(input.get(i));
        }
    }
}
