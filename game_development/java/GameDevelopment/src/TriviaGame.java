 import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class TriviaGame {
 
@SuppressWarnings("ConvertToTryWithResources")
 
public static void main(String[] args) throws FileNotFoundException {
 
ArrayList<Question> questions = new ArrayList<>();
 
Scanner scanner = new Scanner(System.in);
 
int playerOneScore = 0;
 
int playerTwoScore = 0;
 
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
 
for (int i = 0; i < questions.size(); i++) {
 
if (i % 2 == 0) {
 
System.out.println("Player One, please answer the following" + "question:\n");
 
System.out.println(questions.get(i).toString());
 
String answer = scanner.next();
 
if (answer.equals(questions.get(i).getCorrectAnswer())) {
 
playerOneScore++;
 
System.out.println("You got it right! You have " + playerOneScore + " point(s).\n");
 
} else {
 
System.out.println("Sorry, that was incorrect! You have " + playerOneScore + " point(s).\n");
 
}
 
} else {
 
System.out.println("Player Two, please answer the following" + "question:\n");
 
System.out.println(questions.get(i).toString());
 
String answer = scanner.next();
 
if (answer.equals(questions.get(i).getCorrectAnswer())) {
 
playerTwoScore++;
 
System.out.println("You got it right! You have " + playerTwoScore + " point(s).\n");
 
} else {
 
System.out.println("Sorry, that was incorrect! You have " + playerTwoScore + " point(s).\n");
 
}
 
}
 
}
 
if (playerOneScore > playerTwoScore) {
 
System.out.println("Player One wins with");
 
} else if (playerTwoScore > playerOneScore) {
 
System.out.println("Player Two wins with");
 
} else {
 
System.out.println("We have a tie!");
 
}
 
scanner.close();
 
}
}                      answeredCorrectly = true;
