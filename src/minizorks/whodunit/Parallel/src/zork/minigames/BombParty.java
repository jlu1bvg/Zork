package minizorks.whodunit.Parallel.src.zork.minigames;

import java.util.*;

import minizorks.whodunit.Parallel.src.zork.proto.Minigame;
import minizorks.whodunit.Parallel.src.zork.utils.Dictionary;
import minizorks.whodunit.Parallel.src.zork.utils.Timer;
import minizorks.whodunit.Parallel.src.zork.Game;

public class BombParty extends Minigame {

    private Scanner in;
    private String syllable;
    private boolean finished;
    private int score;

    public BombParty() {
        super("Bomb Party");
    }

    public void play() {
        in = new Scanner(System.in);

        Game.print("/bWelcome to Bomb Party! Try to survive as long as possible.");
        Game.print("/bTo play, write a word that contains the syllable in /rRED/b once the console tells you to.");
        System.out.print("Type start once you have understood the rules: ");

        finished = false;

        if(in.nextLine().equalsIgnoreCase("start")) {
            while(!finished) { nextRound(); }
        }
    }

    private void nextRound() {
        try {
            // Random syllable generation (some uncommon letters are removed so that it is easier)
            String letters = "abcdefghilmnoprstu";
            syllable = "";
            for (int i = 0; i < 2; i++) {
                syllable += letters.charAt((int)(Math.random() * letters.length()));
            }

            Game.print("/rSyllable: " + syllable);
            
            Game.print("/bIt's your turn. You have 10 seconds to respond.");

            Timer time = new Timer(10); // Timer for each round

            time.start(); // Start the timer
            String response = in.nextLine().toLowerCase(); // User input

            if (time.isOver()|| !response.contains(syllable) || !isValidWord(response)) { // If time has ran out, or the word does not contain the required subsegment, or if it is not a valid english word, then we cannot continue
                Game.print("/rYou have been eliminated!/b"); // Inform the player
                finished = true; // Game is done
                Game.player.setResult(false); // Status to lost
                score = 0; // reset the score
                return;
            }

            // If we get here, it means that we have passed

            System.out.println();
            score++; // Score is incremented

            if(score >= 5) { // If we reach round 5, then we won
                Game.player.setResult(true); // Status to won
                score = 0; // reset the score
                finished = true; // Game is done
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private boolean isValidWord(String word) {
        return Dictionary.exists(word);
    }

    @Override
    public void startGame(String... args) {
        play();
    }
}
