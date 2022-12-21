package com.keithlienert;

import java.util.ArrayList;

/**
 * Fuel required to launch a given module is based on its mass
 *
 * Specicially, to find the fuel required for a module, take its mass, divide by three, round down,
 * and subtract 2.
 *
 * Example:
 *
 * For a mass of 12, divide by 3 and round down to get 4, then subtract 2 to get 2.
 * For a mass of 14, divide by 3 and round down to get 4, then subtract 2 to get 2.
 * For a mass of 1969, the fuel required is 654
 * For a mass of 100756, the fuel required is 33583.
 *
 * The fuel counter-upper needs to know the TOTAL fuel requirement.
 * To find it, individually calculate the fuel needed for the mass of each module (your puzzle input)
 * then add together all the fuel values.
 */

public class Day1_2019 {

    public int determineFuelForModule(int mass) {
        // divide by 3, round down, subtract 2
        return Math.round(mass / 3) - 2;
    }

    public int determineFuelAllModule(ArrayList<Integer> moduleMasses) {
        int totalFuel = 0;
        for (Integer mass : moduleMasses) {
            totalFuel += determineFuelForModule(mass);
        }
        return totalFuel;
    }
}
