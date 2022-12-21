package com.keithlienert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day1Test {
    
    Day1 dayOne = new Day1();

    @Test
    void totalCaloriesTEST1() {
        assertEquals(24000, dayOne.findMax(dayOne.readFile("input/day1/test1.txt")));
    }

    @Test
    void totalCaloriesTEST2() {
        assertEquals(26000, dayOne.findMax(dayOne.readFile("input/day1/test2.txt")));
    }

    @Test
    void totalCaloriesTEST3() {
        assertEquals(40000, dayOne.findMax(dayOne.readFile("input/day1/test3.txt")));
    }

    @Test
    void totalCaloriesTEST4() {
        assertEquals(27912, dayOne.findMax(dayOne.readFile("input/day1/test4.txt")));
    }

}
