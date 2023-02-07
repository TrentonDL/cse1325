import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    private ArrayList<Question> questions;

    public Quiz(){
        this.questions = new ArrayList<>();
    }

    private void loadQuiz(){
        ArrayList<String> answers1 = new ArrayList<>();
        answers1.add( "Dog");
        answers1.add( "Snake");
        answers1.add("Dragon");
        answers1.add("Spider");
        questions.add(new Question("Which animal is not real?", answers1, 2));
        
        ArrayList<String> answers2 = new ArrayList<>();
        answers2.add( "Bill Gates");
        answers2.add( "Jeff Bazos");
        answers2.add("Mark Cuban");
        answers2.add("Joe Rogan");
        questions.add(new Question("Who founded Microsoft?", answers2, 0));
    }

    public double takeQuiz(){
        loadQuiz();
        int proposedAnswer = 0;
        int correctAnswer = 0;
        int totalQuestions = questions.size();
        Scanner input = new Scanner(System.in);

        for(Question q: questions){
            System.out.println(q);
            System.out.print("Enter your answer: ");
            proposedAnswer = input.nextInt();
            if(q.checkAnswer(proposedAnswer)){
                ++correctAnswer;
            }
            
        }
        input.close();
        return (correctAnswer/(double)totalQuestions) * 100;
    }
}