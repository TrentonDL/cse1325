import java.util.ArrayList;

public class Question {
    public Question(String question, ArrayList<String> answers, int rightAnswer){
        this.question = question;
        this.answers = answers;
        this.rightAnswer = rightAnswer;

        if(rightAnswer < 1 || rightAnswer > answers.size()){
            throw new IllegalArgumentException("Invaild Answer Choice");
        }
    }

    public Boolean checkAnswer(int answer){
        return (answer == rightAnswer);
    }

    @Override
    public String toString(){
        String s = 
        System.out.println(nextQuestionNumber + ". " + question);
        int a = 1;
        for(String Answer : answers){
            System.out.println("   " + a + ") " + Answer);
            ++a;
        }
        return;
    }

    private String question;

    private ArrayList<String> answers;

    private int rightAnswer;

    private int nextQuestionNumber = 1;

    private final int questionNumber = ++nextQuestionNumber;
}
