public class Quizzer {
    public static void main(String[] args) {
        try{
            Quiz resultQuiz = new Quiz();
            double grade = resultQuiz.takeQuiz();
    
            System.out.println("Your grade : " + grade);
        }catch (IllegalArgumentException i){
            System.err.println("Invaild Argument Entered");
            System.exit(-1);
        } 
    }
}