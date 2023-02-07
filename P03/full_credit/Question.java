import java.util.ArrayList;

public class Question {
    public Question(String question, ArrayList<String> answers, int rightAnswer){
        this.question = question;
        this.answers = answers;
        this.rightAnswer = rightAnswer;
        this.questionNumber = nextQuestionNumber++;
        
        if(rightAnswer < 1 || rightAnswer > answers.size()){
            throw new IllegalArgumentException("Invaild Answer Choice");
        }
    }

    public Boolean checkAnswer(int answer){
        return (answer == rightAnswer);
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder(questionNumber + ". " + question + "\n");
        int a = 1;
        for(String Answer : answers){
            s.append("   " + a + ") " + Answer + " \n");
            ++a;
        }
        return s.toString();
    }

    private String question;
    private ArrayList<String> answers;
    private int rightAnswer;
    private static int nextQuestionNumber = 1;
    private final int questionNumber;
}
