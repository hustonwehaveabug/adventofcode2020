package org.example.task1;

import org.example.utils.FileReader;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Part2 {

    public static void main(String[] args) {
        int sum = 2020;

        List<Integer> input = FileReader.readFileAsIntegers("task1-input.txt");

        for (int i = 0; i < input.size() - 2; i++)
        {

            Set<Integer> set = new HashSet<>();
            int currentSum = sum - input.get(i);
            for (int j = i + 1; j < input.size(); j++)
            {
                if (set.contains(currentSum - input.get(j)))
                {
                    System.out.println(String.format("Numbers are %d, %d, %d", input.get(i), input.get(j), currentSum - input.get(j)));
                    long multiply = (long) input.get(i) * (long) input.get(j)  * (long)(currentSum - input.get(j));
                    System.out.println("Multiplication = " + multiply);
                    return;
                }
                set.add(input.get(j));
            }
        }
    }
}
