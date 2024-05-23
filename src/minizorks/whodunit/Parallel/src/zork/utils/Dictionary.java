package minizorks.whodunit.Parallel.src.zork.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Dictionary {
    
    private static Set<String> words;

    public static void initDictionary() throws IOException {
		Path path = Path.of("src"+File.separator+"minizorks"+File.separator+"whodunit"+File.separator+"Parallel"+File.separator+"src"+File.separator+"zork"+File.separator+"data"+File.separator+"words.txt");
		String dictionary = Files.readString(path);

        words = new HashSet<String>(Arrays.asList(dictionary.split(""+File.separator+"R")));
    }

    public static boolean exists(String word) {
        return words.contains(word);
    }
}
