public class Quizzer {
    public static void main(String[] args) {
        Quiz resultQuiz = new Quiz();
        resultQuiz.takeQuiz();

        System.out.println("Your grade : " + resultQuiz);
        
        /*try{

        }catch (IllegalArgumentException i){
            System.err.println("Invaild Argument Entered");
            System.exit(-1);
        } */
    }
}