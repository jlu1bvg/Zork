package zork.utils;

public class progressbar {
    public static String generateProgressBar(int current, int maximum, int barLength) {
        if (maximum <= 0) {
            throw new IllegalArgumentException("Maximum value must be greater than 0");
        }

        if (current < 0) {
            current = 0;
        }
        if (current > maximum) {
            current = maximum;
        }

        double progressFraction = (double)current / maximum;
        int filledLength = (int)(barLength * progressFraction);
        StringBuilder bar = new StringBuilder();

        for (int i = 0; i < filledLength; i++) {
            bar.append('█');
        }
        for (int i = filledLength; i < barLength; i++) {
            bar.append('-');
        }

        return String.format("[%s] %d/%d (%.2f%%)", bar.toString(), current, maximum, progressFraction * 100);
    }
}
