package com.waystech.algorithm;

import org.junit.jupiter.api.Test;
import org.waysTech.RemoveDuplicatesFromRows;
import org.waysTech.SumOfDigits;
import org.waysTech.TimeInWords;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


class AlgorithmsSqlApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testRemoveDuplicates() {
        int[][] array = {
                {1, 2, 2, 3},
                {4, 4, 5, 6},
                {7, 8, 9, 9},
                {10, 11, 12, 12, 12}
        };

        int[][] expected = {
                {1, 2, 0, 3},
                {4, 0, 5, 6},
                {7, 8, 9, 0},
                {10, 11, 12, 0, 0}
        };

        RemoveDuplicatesFromRows.removeDuplicates(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testEmptyRows() {
        int[][] array = {
                {},
                {1, 2, 3},
                {},
                {4, 5, 4}
        };

        int[][] expected = {
                {},
                {1, 2, 3},
                {},
                {4, 5, 0}
        };

        RemoveDuplicatesFromRows.removeDuplicates(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSingleElementRows() {
        int[][] array = {
                {1},
                {2},
                {3},
                {4}
        };

        int[][] expected = {
                {1},
                {2},
                {3},
                {4}
        };

        RemoveDuplicatesFromRows.removeDuplicates(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testNoDuplicates() {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] expected = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        RemoveDuplicatesFromRows.removeDuplicates(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testAllDuplicates() {
        int[][] array = {
                {1, 1, 1},
                {2, 2, 2},
                {3, 3, 3}
        };

        int[][] expected = {
                {1, 0, 0},
                {2, 0, 0},
                {3, 0, 0}
        };

        RemoveDuplicatesFromRows.removeDuplicates(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSumOfDigits() {
        assertEquals(6, SumOfDigits.sumOfDigits("123"));
        assertEquals(15, SumOfDigits.sumOfDigits("555"));
        assertEquals(0, SumOfDigits.sumOfDigits("0"));
        assertEquals(0, SumOfDigits.sumOfDigits(""));
        assertEquals(21, SumOfDigits.sumOfDigits("678"));
    }

    @Test
    public void testTimeInWords() {
        assertEquals("five o’clock", TimeInWords.timeInWords(5, 0));
        assertEquals("quarter past five", TimeInWords.timeInWords(5, 15));
        assertEquals("half past five", TimeInWords.timeInWords(5, 30));
        assertEquals("quarter to six", TimeInWords.timeInWords(5, 45));
        assertEquals("one minute past five", TimeInWords.timeInWords(5, 1));
        assertEquals("twenty-nine minutes to six", TimeInWords.timeInWords(5, 31));
    }
}
