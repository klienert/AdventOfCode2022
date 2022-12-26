package com.keithlienert;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day2Test {
    
    Day2 dayTwo = new Day2();

    String TEST1 = "A Y";
    String TEST2 = "B X";
    String TEST3 = "C Z";



//    @Test
//    void scoreTEST1() {
//        assertEquals(8, dayTwo.scoreRound(TEST1));
//    }
//
//    @Test
//    void scoreTEST2() {
//        assertEquals(1, dayTwo.scoreRound(TEST2));
//    }
//
//    @Test
//    void scoreTEST3() {
//        assertEquals(6, dayTwo.scoreRound(TEST3));
//    }

    @Test
    void scoreTEST4() {
        assertEquals(4, dayTwo.partTwo(TEST1));
    }

    @Test
    void scoreTEST5() {
        assertEquals(1, dayTwo.partTwo(TEST2));
    }

    @Test
    void scoreTEST6() {
        assertEquals(7, dayTwo.partTwo(TEST3));
    }



}
