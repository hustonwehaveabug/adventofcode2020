package org.example.task6;

import lombok.AllArgsConstructor;
import org.example.Validator;

import java.util.*;

@AllArgsConstructor
public class Day6Validator implements Validator {

    private final List<String> input;
    private final String DELIMITER = ";";

    @Override
    public long validatePartOne() {
        List<char[]> groups = convertToArrayGroups();
        return groups.stream()
                .map(this::countYesAnswers)
                .map(Set::size)
                .reduce(0, Integer::sum);
    }

    private Set<Character> countYesAnswers(char[] chars) {
        Set<Character> result = new HashSet<>();
        for (char character : chars) {
            result.add(character);
        }
        return result;
    }

    @Override
    public long validatePartTwo() {
        List<String> groups = convertToStringGroups();
        return groups.stream()
                .map(this::countCommonYesAnswers)
                .map(Set::size)
                .reduce(0, Integer::sum);
    }

    private Set<Character> countCommonYesAnswers(String group) {
        Set<Character> result = new HashSet<>();
        String[] lines = group.split(DELIMITER);
        char[] charsToCompare = lines[0].toCharArray();
        for (int i = 0; i < lines.length; i++) {
            charsToCompare = findCommonElement(charsToCompare, lines[i].toCharArray());
        }
        for (char character : charsToCompare) {
            result.add(character);
        }
        return result;
    }

    private List<char[]> convertToArrayGroups() {
        List<char[]> result = new ArrayList<>();
        Iterator<String> itr = input.iterator();
        StringBuilder sb = new StringBuilder();
        while (itr.hasNext()) {
            String line = itr.next();
            sb.append(line);
            if (line.isEmpty() || !itr.hasNext()) {
                result.add(sb.toString().toCharArray());
                sb = new StringBuilder();
            }
        }
        return result;
    }

    private List<String> convertToStringGroups() {
        List<String> result = new ArrayList<>();
        Iterator<String> itr = input.iterator();
        StringBuilder sb = new StringBuilder();
        while (itr.hasNext()) {
            String line = itr.next();
            sb.append(line);
            if (!line.isEmpty()) {
                sb.append(DELIMITER);
            }
            if (line.isEmpty() || !itr.hasNext()) {
                sb.setLength(sb.length() - 1);
                result.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return result;
    }

    public char[] findCommonElement(char[] a, char[] b) {

        Set<Character> commonElements = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    commonElements.add(a[i]);
                }
            }
        }
        return convert(commonElements);
    }

    private char[] convert(Set<Character> set) {
        int size = set.size();
        char[] result = new char[size];
        int i = 0;
        for (Character character : set) {
            result[i] = character;
            i++;
        }
        return result;
    }
}
