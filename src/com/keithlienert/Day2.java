package com.keithlienert;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * The first column (opponent) is going to play:
 * A for Rock, B for Paper, and C for Scissors.
 * The second column (player)
 * X for Rock, Y for Paper, and Z for Scissors
 *
 * Score: 1 for Rock, 2 for Paper, 3 for Scissors
 * 0 if you lose
 * 3 for a draw
 * 6 if you win
 *
 * i.e. AY (rock and paper), player wins (6 points) and uses 'Y' (paper)
 * for 2 points == 8 points total
 * AY --> 8 points
 * BX --> 1 point
 * CZ --> 6 points
 * TOTAL = 15
 *
 */

public class Day2 {
    private HashMap<String, Integer> gameMap;
    private int score = 0;
    static final int ROCK = 1;
    static final int PAPER = 2;
    static final int SCISSORS = 3;
    static final int LOSS = 0;
    static final int DRAW = 3;
    static final int WIN = 6;


    /**
     * Takes in a file and returns it into a String
     * @return the string result of the input file
     */
    public static String readFile(String filePath) {
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
        return result;
    }

    public void gameMap() {
        gameMap = new HashMap<>();
        gameMap.put("A", ROCK);
        gameMap.put("B", PAPER);
        gameMap.put("C", SCISSORS);
        gameMap.put("X", ROCK);
        gameMap.put("Y", PAPER);
        gameMap.put("Z", SCISSORS);
    }

    /**
     * takes a single line of a string and compares the first entry & second entry for scoring
     * @param str the str
     */
    public void scoring(String str) {
        gameMap();
        String[] match = str.split(" "); // split by the space between in each 'move'

        System.out.println("StrArr: " + match[0] + " -- " + match[1]);





    }


    public static void main(String[] args) {
        Day2 day2 = new Day2();
//        System.out.println(readFile("input/day2/test1.txt"));
        day2.scoring(readFile("input/day2/test1.txt"));

    }

}
