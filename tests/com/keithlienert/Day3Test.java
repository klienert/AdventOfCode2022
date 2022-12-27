package com.keithlienert;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day3Test {

    Day3 dayThree = new Day3();

    String TEST1 = "vJrwpWtwJgWrhcsFMMfFFhFp";
    String TEST2 = "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL";
    String TEST3 = "PmmdzqPrVvPwwTWBwg";
    String TEST4 = "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn";
    String TEST5 = "ttgJtRGJQctTZtZT";
    String TEST6 = "CrZsJsPPZsGzwwsLwLmpwMDw";

    // test results for the 'priority'

    @Test
    void test1() {
        assertEquals('p', dayThree.findSharedItem(TEST1));
        assertEquals(16, dayThree.priorityConversion('p'));
    }

    @Test
    void test2() {
        assertEquals('L', dayThree.findSharedItem(TEST2));
        assertEquals(38, dayThree.priorityConversion('L'));
    }

    @Test
    void test3() {
        assertEquals('P', dayThree.findSharedItem(TEST3));
        assertEquals(42, dayThree.priorityConversion('P'));
    }

    @Test
    void test4() {
        assertEquals('v', dayThree.findSharedItem(TEST4));
        assertEquals(22, dayThree.priorityConversion('v'));
    }

    @Test
    void test5() {
        assertEquals('t', dayThree.findSharedItem(TEST5));
        assertEquals(20, dayThree.priorityConversion('t'));
    }

    @Test
    void test6() {
        assertEquals('s', dayThree.findSharedItem(TEST6));
        assertEquals(19, dayThree.priorityConversion('s'));
    }


}
