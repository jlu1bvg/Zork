package zork.utils;

public class Ascii {
    
    private static final String RESET = "\033[0m";
    private static final String[] COLORS = {
            "\033[31m", 
            "\033[32m",
            "\033[33m", 
            "\033[34m",
            "\033[35m", 
            "\033[36m",
            "\033[37m"  
    };

    public static void printAsciiArtWithAnimation(String asciiArt) {
        String[] lines = asciiArt.split("\n");

        for (String line : lines) {
            for (char c : line.toCharArray()) {
                int colorIndex = (int) (Math.random() * COLORS.length);
                System.out.print(COLORS[colorIndex] + c + RESET);
                try {
                    Thread.sleep(getDelay(c));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
    }
    private static int getDelay(char c) {
        switch (c) {
            case '|':
            case '_':
                return 1;
            default:
                return 1;
        }
    }

    public static void clearScreen() {
        //sry joline this wont work for ur mac
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
