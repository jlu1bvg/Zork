package minizorks.cityzork.src.zork.zork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InitAscii {
        public static void fillAsciiArt (String roomName) throws FileNotFoundException, IOException {
        // \\bin\\zork\\data\\cutscene.txt
        // System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        String roomNameFile = roomName + ".txt";
        File f = new File(new File("").getAbsolutePath() + File.separator + "src" + File.separator + "minizorks" + File.separator + "cityzork" + File.separator + "bin" + File.separator + "locations" + File.separator + roomNameFile);
        BufferedReader reader = new BufferedReader(new FileReader(f));
        String line = null;
        while((line = reader.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                System.out.print(line.charAt(i));
            }
            System.out.println();
            continue;

        }
        reader.close();
    }
}
