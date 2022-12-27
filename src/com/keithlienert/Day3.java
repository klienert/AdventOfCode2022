package com.keithlienert;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;

public class Day3 {
    HashMap<Character, Integer> map;
    TreeMap<Character, Integer> conversionMap;

    /**
     * Takes a string, splits into two 'compartments'
     * Finds the common letter (upper or lowercase) in both compartments
     * @param  items  the list of items in a 'rucksack'
     * @return  String of the common letter (single letter)
     */
    public Character findSharedItem(String items) {
        map = new HashMap<>();
        char res = 0;
        int len = items.length();
        int half = Math.abs(len / 2);

        // split string into 2 separate strings
        String s1 = items.substring(0, half);
        String s2 = items.substring(half, len);

        // HashMap for first string
        for (int i = 0; i < s1.length(); i++) {
            if (map.get(s1.charAt(i)) == null) {
                map.put(s1.charAt(i), 1);
            } else {
                map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
            }
        }
        // iterate through 2nd string, checking for K/V match
        for (int i = 0; i < s2.length(); i++) {
            if (map.containsKey(s2.charAt(i))) {
                res = s2.charAt(i);
//                results.add(String.valueOf(s2.charAt(i)));
            }
        }
        return res;
    }

    /**
     * Takes in a file and returns it into a String
     * scoreRound() --> Part one
     * @return the string result of the input file
     */
    public String readFile(String filePath) {
        int sum = 0;
        String result = "";

        try {
            BufferedReader input = new BufferedReader(new FileReader(filePath));
            while (input.ready()) {
              sum += priorityConversion(findSharedItem(input.readLine()));
//                result += input.readLine() + "\n";
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Sum: " + sum);
        return result;
    }

    /**
     * Builds a conversion map for letters to numbers of priority.
     */
    public void buildConversionMap() {
        conversionMap = new TreeMap<>();
        String a = "abcdefghikjlmnopqrstuvwxyzABCDEFGHIKJLMNOPQRSTUVWXYZ";
        for (int i = 0; i < a.length(); i++) {
            conversionMap.put(a.charAt(i), i + 1);
        }
    }

    /**
     * Outputs an int representing a priority number for each char entered
     * Utilizes the buildConversion() map to create the priority number
     * @param item the item
     * @return the int
     */
    public int priorityConversion(char item) {
        int result = 0;
        // take the string and assign it a value (a-z, A-Z)
        buildConversionMap();

        // use a sortedMap for conversion
        if (conversionMap.containsKey(item)) {
            conversionMap.get(item);
            result = conversionMap.get(item);
        }
        return result;
    }


    public static void main(String[] args) {
        Day3 dayThree = new Day3();

        System.out.println(dayThree.readFile("input/day3/test.txt"));
        System.out.println(dayThree.readFile("input/day3/input3.txt"));





    }


}
