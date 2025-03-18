import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TriviaGame2 {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Question> questions = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the total number of players: ");
        int totalPlayers = scanner.nextInt();
        System.out.print("\n\n\n\n");

        File file = new File("/home/rudra/Desktop/college/term-2/game_development/java/questions.txt");

        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String question = sc.nextLine();
                String firstAnswer = sc.nextLine();
                String secondAnswer = sc.nextLine();
                String thirdAnswer = sc.nextLine();
                String fourthAnswer = sc.nextLine();
                String correctAnswer = sc.nextLine();

                Question q = new Question(question, firstAnswer, secondAnswer, thirdAnswer, fourthAnswer,
                        correctAnswer);
                questions.add(q);
            }
            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int[] playerScores = new int[totalPlayers];
        for (int i = 0; i < totalPlayers; i++) {
            Collections.shuffle(questions);
            playerScores[i] = 0;
            for (int j = 0; j < questions.size(); j++) {
                System.out.println("Player " + (i + 1) + ", Please answer the following questions\n\n");
                System.out.println(questions.get(j).toString());
                System.out.println("\n");

                boolean skip = false;
                int attempts = 0;
                while (!skip) {
                    System.err.print("Enter Your Choice: ");
                    String answer = scanner.next();

                    if (answer.equals(questions.get(j).getCorrectAnswer())) {
                        playerScores[i]++;
                        System.out.println("\nThat was the correct \n moving to the next one.....\n\n");
                        skip = true;
                    } else {
                        if (attempts >= 3) {
                            System.out.println("\nFailed to answer the question. \n skipping..............\n\n");
                            skip = true;
                        } else {
                            System.out.print("\nOops! that was wrong , do you want to attempt again (y/n): ");
                            String choice = scanner.next();
                            System.out.println("\n\n\n");

                            if (choice.equalsIgnoreCase("y")) {
                                playerScores[i]--;
                                attempts++;
                            } else {
                                skip = true;
                            }

                        }

                    }
                }

            }

        }

        int maxScore = playerScores[0];
        int maxIndex = 0;

        System.out.println("\n\n\n\n");
        System.out.println("Thanks for playing the game \nHere are Your Standings:-");
        for (int i = 0; i < totalPlayers; i++) {
            System.out.println("PLayer " + (i + 1) + " - " + playerScores[i]);

            if (playerScores[i] > maxScore) {
                maxScore = playerScores[i];
                maxIndex = i;
            }
        }

        System.out.println("\nPlayer " + (maxIndex + 1) + "wins with total of " + maxScore + " Points");
        scanner.close();
    }
}