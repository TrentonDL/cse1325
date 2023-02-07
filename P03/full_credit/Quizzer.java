public class Quizzer {
    public static void main(String[] args) {
        try{
            Double result = Quiz.takeQuiz();

            System.out.println("Your grade : " + result);
        }catch (IllegalArgumentException i){
            System.err.println("Invaild Argument Entered");
            System.exit(-1);
        } 
    }
}