package com.keithlienert;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class Day1Test_2019 {

    Day1_2019 day12019 = new Day1_2019();

    @Test
    void determineFuelForModuleMass12() {
        assertEquals(2, day12019.determineFuelForModule(12));
    }

    @Test
    void determineFuelForModuleMass14() {
        assertEquals(2, day12019.determineFuelForModule(14));
    }

    @Test
    void determineFuelForModuleMass1969() {
        assertEquals(654, day12019.determineFuelForModule(1969));
    }

    @Test
    void determineFuelForModuleMass100756() {
        assertEquals(33583, day12019.determineFuelForModule(100756));
    }

    @Test
    void determineFuelAllModule() throws FileNotFoundException {
        ArrayList<Integer> listOfModMasses = new ArrayList<>();
        // access file
        File text = new File("input/day1_input.txt");
        Scanner sc = new Scanner(text);
        while(sc.hasNextLine()) {
            listOfModMasses.add(Integer.parseInt(sc.nextLine()));
        }
        assertEquals(3397667, day12019.determineFuelAllModule(listOfModMasses));

    }
}