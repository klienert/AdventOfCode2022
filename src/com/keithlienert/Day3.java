package com.keithlienert;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day3 {
    String alphabet = "0abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * Takes in a file and returns it into a String
     * scoreRound() --> Part one
     * @return the string result of the input file
     */
    public static ArrayList<String> readFile(String filePath) {
        ArrayList<String> newList = new ArrayList<>();
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

    /**
     * Takes a string, splits into two 'compartments'
     * Finds the common letter (upper or lowercase) in both compartments
     * @param  items  the list of items in a 'rucksack'
     * @return  Character of the common letter (single letter)
     */
    public int priorityTotal(ArrayList<String> items) {
        int total = 0;
        int score = 0;
        for (String s : items) { // iterate through arrayList of strings (each rucksack)
            int[] chars = new int[s.length()];
            int i = 0;
            for (String t : s.split("")) {
                chars[i] = alphabet.indexOf(t);
                i++;
            }
            int[] first = Arrays.copyOfRange(chars, 0, chars.length / 2);
            int[] second = Arrays.copyOfRange(chars, chars.length / 2, chars.length);

            for (int j = 0; j < first.length; j++) {
                for (int k = 0; k < second.length; k++ ) {
                    if (first[j] == second[k]) {
                        score = first[j];
//                        System.out.println();
                    }
                }
            }
            System.out.print("SCORE: " + score);
            total += score;
            System.out.println("     TOTAL: " + total);
        }
        return total;
    }

    public static void main(String[] args) {
        Day3 dayThree = new Day3();
        ArrayList<String> newList = readFile("input/day3/input3.txt");
        dayThree.priorityTotal(newList);
    }
}
