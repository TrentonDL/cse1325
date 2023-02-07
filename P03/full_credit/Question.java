import java.util.ArrayList;

public class Question {
    public Question(String question, ArrayList<String> answers, int rightAnswer){
        this.question = question;
        this.answers = answers;
        this.rightAnswer = rightAnswer;
        this.questionNumber = nextQuestionNumber++;
    }

    public boolean checkAnswer(int answer){
        if(answer < 1 || answer >= answers.size()){
            throw new IllegalArgumentException("Invaild Answer Choice");
        }
        return (answer-1 == rightAnswer);
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
