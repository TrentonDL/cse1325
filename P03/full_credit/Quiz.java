import java.util.ArrayList;

public class Quiz {
    private class question {
        Quiz.loadQuiz();
    }

    private void loadQuiz(){
        Question[] question;
    
        ArrayList<String> answers1 = new ArrayList<>();
        answers1.add(1, "Dog");
        answers1.add(2, "Snake");
        answers1.add(3,"Dragon");
        answers1.add(4,"Spider");
        question[0] = new Question("Which animal is not real?", answers1, 3);
        
        ArrayList<String> answers2 = new ArrayList<>();
        answers1.add(1, "Bill Gates");
        answers1.add(2, "Jeff Bazos");
        answers1.add(3,"Mark Cuban");
        answers1.add(4,"Joe Rogan");
        question[1] = new Question("Which animal is not real?", answers2, 1);
       
    }
}