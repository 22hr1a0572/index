QUIZAPP USING JAVA CODE
'''
import java.util.Scanner;

public class QuizApp {

    
    static String[][] htmlQuestions = {
            {"HTML stands for?", "Hyper Text Markup Language", "Hyperlinks Text Marking Language",
                    "HighText Machine Language", "1"},
            {"Which tag creates a paragraph?", "<p>", "<h1>", "<div>", "1"},
            {"HTML is a ___ language", "Programming", "Markup", "Database", "2"}
    };

    static String[][] cssQuestions = {
            {"CSS stands for?", "Color Style Sheet", "Cascading Style Sheets", "Creative Style System", "2"},
            {"Which symbol is used for IDs?", "#", ".", "&", "1"},
            {"Which property is used for text color?", "color", "font-color", "text-color", "1"}
    };

    static String[][] jsQuestions = {
            {"JS stands for?", "JavaSource", "JavaScript", "JustScript", "2"},
            {"Which keyword declares a variable?", "var", "int", "string", "1"},
            {"Which is an array?", "{}", "[]", "()", "2"}
    };

    
    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        int score = 0;

        System.out.println("Select Subject:");
        System.out.println("1. HTML");
        System.out.println("2. CSS");
        System.out.println("3. JavaScript");

        int choice = sc.nextInt();

        String[][] selectedQuestions;

        if (choice == 1)
            selectedQuestions = htmlQuestions;
        else if (choice == 2)
            selectedQuestions = cssQuestions;
        else
            selectedQuestions = jsQuestions;

        System.out.println("\nStarting Quiz... You have 10 seconds per question!");

        for (int i = 0; i < selectedQuestions.length; i++) {

            String[] q = selectedQuestions[i];

            System.out.println("\nQ" + (i + 1) + ". " + q[0]);
            System.out.println("1. " + q[1]);
            System.out.println("2. " + q[2]);
            System.out.println("3. " + q[3]);

            long start = System.currentTimeMillis();

            System.out.print("Your answer: ");

            while (!sc.hasNextInt()) {
                if (System.currentTimeMillis() - start > 10000) { // 10 sec
                    System.out.println("\n⏳ Time over!");
                    break;
                }
            }

            long end = System.currentTimeMillis();

            if (end - start > 10000) {
                continue; 
            }

            int ans = sc.nextInt();

            if (String.valueOf(ans).equals(q[4])) {
                score++;
            }
        }

        System.out.println("\nQuiz Completed!");
        System.out.println("Your Score = " + score + " out of " + selectedQuestions.length);

        sc.close();
    }
}
'''
PS C:\chinnu> javac QuizApp.java
PS C:\chinnu> java QuizApp.java
Select Subject:
2. CSS
3. JavaScript
1

Starting Quiz... You have 10 seconds per question!

Q1. HTML stands for?
1. Hyper Text Markup Language
2. Hyperlinks Text Marking Language
3. HighText Machine Language
Your answer: 1

Q2. Which tag creates a paragraph?
1. <p>
2. <h1>
3. <div>
Your answer:
Q3. HTML is a ___ language
1. Programming
2. Markup
3. Database
Your answer: 3

Quiz Completed!
Your Score = 1 out of 3
PS C:\chinnu> 
