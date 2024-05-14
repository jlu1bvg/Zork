package minizorks.whodunit.Parallel.src.zork.minigames;

import minizorks.whodunit.Parallel.src.zork.proto.Minigame;
import minizorks.whodunit.Parallel.src.zork.utils.TimeController;
import java.util.Scanner;
import minizorks.whodunit.Parallel.src.zork.Game;

public class TypingTest extends Minigame {

    public TypingTest() {
        super("Typing Test");
    }

    public static final String[] words = {
        "that", "know", "while", "by", "she", "take", "be", "so", "all", "state", "run", "lead", "those", "same", "who",
        "point", "might", "up", "still", "who", "group", "program", "tell", "up", "before", "consider", "in", "increase", "between",
        "man", "back", "also", "by", "still", "will", "go", "over", "order", "point", "move", "all", "hold", "end", "there", "about",
        "early", "in", "again", "can", "you", "turn", "this", "paragraph", "into", "a", "list", "of", "words", "each", "surrounded", "by", "double", "quotes", "and", "a", "comma", "separating"
    };
    
    @Override
    public void startGame(String... args) {
        TimeController timer = new TimeController();
        Scanner in = new Scanner(System.in);

        String sentence = "";
        String[] sentenceArray = new String[20];

        Game.print("/bWelcome to the typing test! Write faster than 60wpm to defeat the owner of the wallet:");
        for (int i = 0, n = 0; i < 20; i++, n = (int) (Math.random() * words.length)) {
            sentence = i == 0 ? words[n] : sentence + " " + words[n];
            sentenceArray[i] = words[n];
        }

        System.out.print("\u001B[31m" + sentence + "\u001B[0m" + "\n\nType start when you are ready: ");

        if(in.nextLine().equalsIgnoreCase("start")) {
            timer.start();

            int countdown = 1, correct = 0;
            boolean started = false;
            try {
                while(true) {
                    if(timer.timeElapsed() == countdown && !started) {
                        if(countdown == 4) {
                            started = !started;
                            Game.print("... Go!");
                        } else {
                            System.out.printf(" " + countdown);
                            countdown++;
                        }
                    }

                    if(started) {
                        String input;
                        if(in.hasNextLine()) { 
                            input = in.nextLine(); 

                            for (int i = 0; i < sentence.length(); i++)
                                if(i < input.length() && input.charAt(i) == sentence.charAt(i)) { correct++; }

                            int accuracy = (int) (((double) correct / sentence.length()) * 100);
                            int wordsPerMinute = (int) (sentenceArray.length / ((double) (timer.timeElapsed() - 4) / 60));

                            Game.print("/bYour accuracy was [/r" + accuracy + "%/b] and your WPM was [" + wordsPerMinute + "]");

                            if(accuracy > 80 && wordsPerMinute >= 60)
                                Game.player.setResult(true);
                            else 
                                Game.player.setResult(false);
                            return;
                        }
                    }
                }
            } catch(IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}