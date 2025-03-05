import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hangman1 {
    public static void main(String[] args) throws FileNotFoundException {
        List<String> words = new ArrayList<String>();
        Scanner scanner = new Scanner(
                new File("/home/rudra/Desktop/college/term-2/game_development/java/words_aplha.txt"));

        while (scanner.hasNext()) {
            words.add(scanner.next());
        }
        // scanner.close();

        // Random random = new Random();
        // String word = words.get(random.nextInt(words.size()));
        // System.out.println(word);

        // char[] wordState = new char[word.length()];
        // for (int i = 0; i < wordState.length; i++) {
        // wordState[i] = '*';
        // }

    }
}
