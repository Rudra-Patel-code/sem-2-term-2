import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman3 {
    public static void main(String[] args) throws FileNotFoundException {
        List<String> words = new ArrayList<String>();
        Scanner scanner = new Scanner(
                new File("/home/rudra/Desktop/college/term-2/game_development/java/words_aplha.txt"));
        Scanner keyboard = new Scanner(System.in);

        while (scanner.hasNext()) {
            words.add(scanner.next());
        }

        Random rand = new Random();
        String word = words.get(rand.nextInt(words.size()));

        System.out.println(word);

        List<Character> playerGuesses = new ArrayList<>();

        int wrongCount = 0;

        while (true) {
            System.out.println(" -------");
            System.out.println(" |     |");
            if (wrongCount >= 1) {
                System.out.println(" O");
            }
            if (wrongCount >= 2) {
                System.out.print("\\ ");
                if (wrongCount >= 3) {
                    System.out.println("/");
                } else {
                    System.out.println("");
                }
            }
            if (wrongCount >= 4) {
                System.out.println(" |");
            }
            if (wrongCount >= 5) {
                System.out.print("/ ");
                if (wrongCount >= 6) {
                    System.out.println("\\");
                } else {
                    System.out.println("");
                }
            }
            System.out.println("");
            System.out.println("");

            if (wrongCount >= 6) {
                System.out.println("You Lose!");
                System.err.println("The word was: " + word);
                break;
            }

            printWordState(word, playerGuesses);

            if (!getPlayerGuess(keyboard, playerGuesses, word)) {
                wrongCount++;
            }

            if (printWordState(word, playerGuesses)) {
                System.out.println("You Win!");
                break;
            }
            System.out.println("Please enter your quess for the Word");
            if (keyboard.nextLine().equals(word)) {
                System.out.println("You Win!");
                break;
            } else {
                System.out.println("No! Try Again");
                // break;
            }
        }
    }

    private static boolean printWordState(String word, List<Character> playerGuesses) {
        int correctCount = 0;
        for (int i = 0; i < word.length(); i++) {

            if (playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                correctCount++;

            } else {
                System.out.print("_");
            }
        }
        System.out.println("");

        return correctCount == word.length();
    }

    private static boolean getPlayerGuess(Scanner keyboard, List<Character> playerGuesses, String word) {
        System.out.println("Please Enter a Letter: ");
        String letterGuess = keyboard.nextLine();
        playerGuesses.add(letterGuess.charAt(0));

        return word.contains(letterGuess);
        // printWordState(word, playerGuesses);

    }
}
