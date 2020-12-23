package org.example.task6;

import org.example.Validator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day6ValidatorTest {

    @Test
    void validatePartOne() {

        // given
        List<String> input = List.of(
                "abc",
                "abcd",
                "",
                "f",
                "g",
                "",
                "abc",
                "",
                "xyz",
                "yzx"
        );
        Validator validator = new Day6Validator(input);
        long expected = 12;

        // when
        long result = validator.validatePartOne();

        // then
        assertEquals(expected, result);
    }

    @Test
    void validatePartTwo() {

        // given
        List<String> input = List.of(
                "abc",
                "abcd",
                "",
                "f",
                "g",
                "",
                "abc",
                "",
                "xyz",
                "yzx"
        );
        Validator validator = new Day6Validator(input);
        long expected = 9;

        // when
        long result = validator.validatePartTwo();

        // then
        assertEquals(expected, result);
    }
}