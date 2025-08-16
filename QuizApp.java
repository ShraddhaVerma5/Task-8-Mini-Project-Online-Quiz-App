import java.util.*;
class Questions{
    String questiontext;
    String[] options;
    int correctanswer;

    public Questions(String questiontext, String[] options, int correctanswer){
        this.questiontext = questiontext;
        this.options = options;
        this.correctanswer = correctanswer;
    }
    public void display(){
        System.out.println(questiontext);
        for(int i=0;i<options.length;i++){
            System.out.println((i+1)+". "+options[i]);
        }
    }
    public boolean checkAnswer(int answer){
        return answer == correctanswer;
    }
}


public class QuizApp {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        List<Questions> quiz = new ArrayList<>();

        quiz.add(new Questions("Which language is used for the android Development ?",
                new String[]{"python","kotlin", "swift", "c#"}, 2));
        quiz.add(new Questions("Whict of these are not an OOPS concept ?",
                new String[]{"Encapsulation", "polymorphism","compilation","Inheritance"},3));
        quiz.add(new Questions("What is defult value of int in java",
                new String[]{"0","null","undefined","1"},1));

        int score = 0;

        System.out.println("===Welcome to the Quix App===");
        System.out.println("Answer the question by writing the numbers like(1/2/3/4");
        System.out.println("-----------------------------------------------------------");

        for(int i=0;i<quiz.size();i++){
            Questions q = quiz.get(i);
            System.out.println("\nQ"+(i+1)+":");
            q.display();

            System.out.println("Enter your answer");
            int ans = sc.nextInt();

            if(q.checkAnswer(ans)){
                System.out.println("Correct!");
                score++;
            }else{
                System.out.println("Wrong Answer"+q.options[q.correctanswer-1]);
            }
        }
        System.out.println("=====Quiz Finished =====");
        System.out.println("Your Score:" + score+"out of"+quiz.size());

        if(score == quiz.size()){
            System.out.println("Excellent ! Full Marks");
        }else if(score >= quiz.size()/2){
            System.out.println("good job");
        }else{
            System.out.println("Keep Practicing");
        }
        sc.close();
    }
}
