import java.util.ArrayList;

public class Question {
    public Question(String question, ArrayList<String> answers, int rightAnswer){
        this.question = question;
        this.answers = answers;
        this.rightAnswer = rightAnswer;
    }

    public Boolean checkAnswer(int answer){
        this.answer = answer;
    }

    @Override
    public String toString(){
        return nextQuestionNumber + ". " + question + "\n";
    }

    private String question;

    private ArrayList<String> answers; 

    private int rightAnswer;

    private int nextQuestionNumber = 1;

    private int final questionNUmber;
}
