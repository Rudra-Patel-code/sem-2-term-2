import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TriviaGame {
    public static void main(String[] args) throws FileNotFoundException {
       
        ArrayList<Question> questions = new ArrayList<>();
        Scanner scanner =new Scanner  (new File("C:\\Users\\harsh\\Desktop\\game development\\Question.txt"));

             while(scanner.hasNext()){
                String question= scanner.nextLine();
                String firstAnswer= scanner.nextLine();
                String secondAnswer= scanner.nextLine();
                String thirdAnswer= scanner.nextLine();
                String fourthAnswer= scanner.nextLine();
                String correctAnswer= scanner.nextLine();
                
                Question q = new Question(question, firstAnswer, secondAnswer, thirdAnswer, fourthAnswer, correctAnswer);
                    questions.add(q);               
                    }

             
        

            }
        }