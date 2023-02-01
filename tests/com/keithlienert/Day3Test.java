package com.keithlienert;

import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day3Test {
    Day3 dayThree = new Day3();
    ArrayList<String> newList;

    /**
     * Takes in a file and returns it into a String
     * scoreRound() --> Part one
     * @return the string result of the input file
     */
    public ArrayList<String> readFile() {
        String filePath = "input/day3/test.txt";
        newList = new ArrayList<>();
        try {
            BufferedReader input = new BufferedReader(new FileReader(filePath));
            while (input.ready()) {
                newList.add(input.readLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return newList;
    }

    // test results for the 'priority'

    @Test
    void test1() {
        assertEquals(157, dayThree.priorityTotal(readFile()));
    }

}
