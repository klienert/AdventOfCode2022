package com.keithlienert;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
//    File text = new File("input/input.txt");
    File text = new File("input/test1.txt"); //TEST FILE
    Scanner sc;

    /**
     * Takes in a file and returns it into a String
     * @return the string result of the input file
     */
    public String readFile(String filePath) {
        String result = "";
        try {
            BufferedReader input = new BufferedReader(new FileReader(filePath));
            while (input.ready()) {
            result += input.readLine() + "\n";
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // remove last newLine char
//        String clean = result.substring(0, result.length()-1);
        return result;
//        return clean;
    }

    /**
     * Takes a string (from file) and arranges the numbers into an Integer arrayList
     * @param str  the str that was the input file
     * @return  Integer array list, blank lines are represented as zeros.
     */
    public ArrayList<Integer> calList(String str) {
        ArrayList<Integer> calList = new ArrayList<>();
        int cal = 0;
        int max = 0;

        for (String s : str.split("\n")) {
            String calStr = s.trim();
            if (calStr.isBlank()) { // blank line
                calList.add(0);
                cal = 0;

            } else {
                calList.add(Integer.parseInt(calStr));
            }
        }
        return calList;
    }

    /**
     * Finds the number in each grouping separated by a newline char
     * @param  str input string
     * @return  max number in from all groupings
     */
    public int findMax(String str) {
        int cal = 0;
        int max = 0;
        ArrayList<Integer> calList = new ArrayList<>();

        for (String s : str.split("\n")) {
            String calStr = s.trim();
            if (calStr.isBlank()) { // blank line
                calList.add(0);
                cal = 0;
                continue;
            } else {
                calList.add(Integer.parseInt(calStr));
//                if (max < cal) {
//                    max = cal;
//                }
//                calList.add(cal);
            }
//            calList.add(max);
//            cal += Integer.parseInt(calStr);

        }

        return max;
    }

    public ArrayList<Integer> maxElves(ArrayList<Integer> arrList) {
        ArrayList<Integer> newList = new ArrayList<>();
        int temp = 0;
        int max = 0;

        for (int i = 0; i < arrList.size(); i++) {
            if (arrList.get(i) != 0) { // not zero (blank)
                temp += arrList.get(i);
                if (max < temp) {
                    max = temp;
                }
            } else {
                newList.add(temp);
                temp = 0;
            }
        }
        newList.add(arrList.get(arrList.size()-1));
        return newList;
    }

    public int topThreeTotal(ArrayList<Integer> arrList) {
        int total = 0;
        // sort arrList large -> small
        arrList.sort((a, b) -> b - a);
        // total the first three elements
        total = arrList.get(0) + arrList.get(1) + arrList.get(2);
        return total;

    }

    public static void main(String[] args) {
        Day1 day1 = new Day1();
//        System.out.println(day1.maxElves(day1.calList(day1.readFile("input/day1/test1.txt"))));
//        System.out.println(day1.topThreeTotal(day1.maxElves(day1.calList(day1.readFile("input/day1/test1.txt")))));
        System.out.println(day1.topThreeTotal(day1.maxElves(day1.calList(day1.readFile("input/day1/input.txt")))));
    }
}
