package org.example.task5;

import lombok.AllArgsConstructor;
import org.example.Validator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class Day5Validator implements Validator {

    private final List<String> input;

    @Override
    public long validatePartOne() {
        return input.stream()
                .map(this::map)
                .max(Comparator.naturalOrder()).orElse(0);
    }

    @Override
    public long validatePartTwo() {
        List<Integer> ids = input.stream()
                .map(this::map)
                .sorted()
                .collect(Collectors.toList());
        return findNotExisting(ids);
    }

    private int findNotExisting(List<Integer> ids) {
        int firstRow = getRow(ids.get(0)) + 1;
        int lastRow = getRow(ids.get(ids.size() - 1)) - 1;
        int previousId = 0;
        boolean isFirstNumber = true;
        for (Integer id : ids) {
            int row = getRow(id);
            if (row < firstRow || row > lastRow) {
                continue;
            }
            if (isFirstNumber) {
                previousId = id - 1;
                isFirstNumber = false;
            }
            if (previousId + 1 != id) {
                return previousId + 1;
            }
            previousId = id;
        }
        return 0;
    }

    private Integer map(String line) {
        char[] chars = line.toCharArray();
        StringBuilder rowBinary = new StringBuilder();
        StringBuilder columnBinary = new StringBuilder();
        for (char character : chars) {
            if (character == 'F') {
                rowBinary.append("0");
            }
            if (character == 'B') {
                rowBinary.append("1");
            }
            if (character == 'R') {
                columnBinary.append("1");
            }
            if (character == 'L') {
                columnBinary.append("0");
            }
        }
        int row = Integer.parseInt(rowBinary.toString(), 2);
        int column = Integer.parseInt(columnBinary.toString(), 2);
        return row * 8 + column;
    }

    private int getRow(int id) {
        return id >> 3;
    }
}
