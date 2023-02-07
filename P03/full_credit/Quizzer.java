public class Quizzer {
    public static void main(String[] args) {
        try {
            Quiz resultQuiz = new Quiz();
            double grade = resultQuiz.takeQuiz();

            System.out.println("Your grade : " + grade);
        } catch (IllegalArgumentException i) {
            System.err.println(i.getMessage() + "\nQuiz Aborted");
            System.exit(-1);
        }
    }
}