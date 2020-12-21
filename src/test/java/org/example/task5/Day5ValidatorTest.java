package org.example.task5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day5ValidatorTest {

    @Test
    void validatePartOne() {
        // given
        List<String> lines = List.of("BFFFBBFRRR", "FFFBBBFRRR", "BBFFBBFRLL");
        Day5Validator validator = new Day5Validator(lines);
        long expectedResult = 820;

        // when
        long result = validator.validatePartOne();

        // then
        assertEquals(expectedResult, result);
    }

    @Test
    void validatePartTwo() {
        // given
        List<String> lines = List.of(
                "FFFFFFFRRR",
                "FFFFFFFRRL",
                "FFFFFFFRLR",
                "FFFFFFFRLL",
                "FFFFFFFLRR",
                "FFFFFFFLRL",
                "FFFFFFFLLR",
                "FFFFFFFLLL",

                "FFFFFFBRRR",
                "FFFFFFBRRL",
                "FFFFFFBRLR",
                "FFFFFFBRLL",
                "FFFFFFBLRR",
                "FFFFFFBLRL",
                "FFFFFFBLLR",
                /*"FFFFFFBLLL",*/ // 8

                "FFFFFBFRRR",
                "FFFFFBFRRL",
                "FFFFFBFRLR",
                "FFFFFBFRLL",
                "FFFFFBFLRR",
                "FFFFFBFLRL",
                "FFFFFBFLLR",
                "FFFFFBFLLL"
                );
        Day5Validator validator = new Day5Validator(lines);
        long expectedResult = 8;

        // when
        long result = validator.validatePartTwo();

        // then
        assertEquals(expectedResult, result);
    }
}