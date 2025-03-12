import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman4 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Choose Mode: \n\t1 for Single Player. \n\t2 for Two Player");
        int noOfPlayers = keyboard.nextInt();
        keyboard.nextLine();

        String word = getWord(noOfPlayers, keyboard);
        List<Character> playerGuesses = new ArrayList<>();
        int wrongCount = 0;

        while (true) {
            printHangman(wrongCount);

            if (wrongCount >= 6) {
                System.out.println("You Lose!");
                System.err.println("The word was: " + word);
                break;
            }

            if (printWordState(word, playerGuesses)) {
                System.out.println("You Win!");
                break;
            }

            if (!getPlayerGuess(keyboard, playerGuesses, word)) {
                wrongCount++;
            }
        }
    }

    private static String getWord(int noOfPlayers, Scanner keyboard) throws FileNotFoundException {
        if (noOfPlayers == 1) {
            List<String> words = new ArrayList<>();
            Scanner scanner = new Scanner(
                    new File("/home/rudra/Desktop/college/term-2/game_development/java/words_aplha.txt"));

            while (scanner.hasNext()) {
                words.add(scanner.next());
            }

            scanner.close();
            Random rand = new Random();
            return words.get(rand.nextInt(words.size()));
        } else {
            System.out.println("Player 1, please enter a word: ");
            String word = keyboard.nextLine().toLowerCase();
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            return word;
        }
    }

    private static void printHangman(int wrongCount) {
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
                System.out.println();
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
                System.out.println();
            }
        }
        System.out.println("\n");
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

        System.out.println();
        return correctCount == word.length();
    }

    private static boolean getPlayerGuess(Scanner keyboard, List<Character> playerGuesses, String word) {
        System.out.println("Please Enter a Letter: ");
        char letterGuess = keyboard.nextLine().toLowerCase().charAt(0);

        if (!playerGuesses.contains(letterGuess)) {
            playerGuesses.add(letterGuess);
        }

        return word.contains(String.valueOf(letterGuess));
    }
}