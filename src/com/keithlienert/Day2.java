package com.keithlienert;

import javax.swing.plaf.synth.SynthUI;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


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
     *
     * @return the string result of the input file
     */
    public void readFile(String filePath) {
        String result = "";
        try {
            BufferedReader input = new BufferedReader(new FileReader(filePath));
            while (input.ready()) {
//                scoreRound(input.readLine());
                partTwo(input.readLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        return result;
    }

    /**
     * Sets the K/V pairs for the game, based on the input and the scores for each game piece
     */
    public HashMap<String, Integer> gameMap() {
        gameMap = new HashMap<>();
        gameMap.put("A", ROCK);
        gameMap.put("B", PAPER);
        gameMap.put("C", SCISSORS);
        gameMap.put("X", ROCK);
        gameMap.put("Y", PAPER);
        gameMap.put("Z", SCISSORS);
        return gameMap;
    }

    /**
     * Takes in the number (from the 'player' turn int array) and returns the proper game piece score
     *
     * @param num is taken from the player's turn
     * @return returns the correct score for each game piece
     */
    public int gamePieceScore(int num) {
        if (num == ROCK) {
            return ROCK;
        } else if (num == PAPER) {
            return PAPER;
        } else {
            return SCISSORS;
        }
    }

    /**
     * Takes in an int that represents the opponents play and returns a losing gamePiece (as an int)
     * @param num  the number of the game piece the opponent played
     * @return  an int that is the losing piece
     */
    public int losePiece(int num) {
        if (num == ROCK) {
            return SCISSORS;
        } else if (num == PAPER) {
            return ROCK;
        } else { // if SCISSORS
            return PAPER;
        }
    }


    /**
     * Takes a single line of a string and compares the first entry & second entry for scoring
     * @param str the input from the file
     * @return int of the total score for the player
     */
    public int scoreRound(String str) {
        gameMap(); // sets up the numbers for the game pieces
        String[] match = str.split(" ");

        if (gameMap.get(match[0]).equals(gameMap.get(match[1]))) { // Draw
            score += DRAW;
        // 3 ways to win 1 3, 2 1, 3 2
        } else if ((gameMap.get(match[0]) == ROCK && gameMap.get(match[1]) == PAPER)) { // ROCK --> SCISSORS
            score += WIN;
        } else if ((gameMap.get(match[0]) == PAPER && gameMap.get(match[1]) == SCISSORS)) { // PAPER --> ROCK
            score += WIN;
        } else if ((gameMap.get(match[0]) == SCISSORS && gameMap.get(match[1]) == ROCK)) { // SCISSORS --> PAPER
            score += WIN;
        } else {
            score += LOSS;
        }
        score += gamePieceScore(gameMap.get(match[1]));
        System.out.println("SCORE: " + score);
        return score;
    }

    /**
     * Second half of Day 2
     * the second column is how the round should end
     * 2nd column: X - lose, Y - Draw, Z - Win
     * @param str the input from the file
     * @return int of the total score for the player
     */
    public int partTwo(String str) {

        gameMap(); // sets up the numbers for the game pieces
        String[] match = str.split(" "); // match[0] - opponent; match[1] - end of round
//        System.out.print("match: " + match[0] + " | " + match[1] + "  ");
        if (match[1].equals("Y")) { // DRAW
            score += gamePieceScore(gameMap.get(match[0])) + DRAW;
//            System.out.println("Draw: " + score + "  -- " + gameMap.get(match[0]));
        } else if (match[1].equals("Z")) {  // WIN
            if (gameMap.get(match[0]) == ROCK) { //
                score += WIN + PAPER;
//                System.out.println("Win: " + score + "  -- " + gameMap.get(match[0]));

            } else if (gameMap.get(match[0]) == PAPER) { //
                score += WIN + SCISSORS;
//                System.out.println("Win: " + score + "  -- " + gameMap.get(match[0]));
            } else { //
                score += WIN + ROCK;
//                System.out.println("Win: " + score + "  -- " + gameMap.get(match[0]));
            }
        } else { // lose
            score += losePiece(gameMap().get(match[0]));
//            System.out.println("Loss: " + score + "  -- " + gameMap.get(match[0]));
        }
        System.out.println(score);
        return score;
    }



        public static void main (String[]args){
            Day2 day2 = new Day2();
//            day2.readFile("input/day2/test1.txt");
            day2.readFile("input/day2/input2.txt");

        }


}
