import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    private Question[] question;

    private void loadQuiz(){
        ArrayList<String> answers1 = new ArrayList<>();
        answers1.add(1, "Dog");
        answers1.add(2, "Snake");
        answers1.add(3,"Dragon");
        answers1.add(4,"Spider");
        question[0] = new Question("Which animal is not real?", answers1, 3);
        
        ArrayList<String> answers2 = new ArrayList<>();
        answers2.add(1, "Bill Gates");
        answers2.add(2, "Jeff Bazos");
        answers2.add(3,"Mark Cuban");
        answers2.add(4,"Joe Rogan");
        question[1] = new Question("Which animal is not real?", answers2, 1);
    }

    public Double takeQuiz(){
        loadQuiz();
        int proposedAnswer = 0;
        Double correctAnswer = 0.0;
        Double totalQuestions = 0.0;

        Scanner in = new Scanner(System.in);
        System.out.printf("\nEnter your answer: ");
        in.nextInt(proposedAnswer);
        in.close();

        Question 

        if(Question.checkAnswer(proposedAnswer)){
            ++correctAnswer;
            ++totalQuestions;
        }
        else{
            ++totalQuestions;
        }
        return (correctAnswer/totalQuestions);
    }
}