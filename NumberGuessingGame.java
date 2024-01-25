/*TASK 1

NUMBER GUESSING GAME

● Generate a random number using the Random class.
● Prompt the user for input using Scanner.
● Compare the user's guess with the generated number.
● Provide feedback on whether the guess is too high, too low, or correct using
conditional statements (if).
● Use a loop (e.g., while) to allow multiple attempts.
● Track the number of attempts and stop the game after a predefined limit. */
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();  //object 
        int randomNum = random.nextInt(50);
        //System.out.println(randomNum);
        Scanner sc = new Scanner(System.in);
        int limit = 10;
        int i=1;
        System.out.println("Welcome to Number Guessing Game!");
        System.out.print("Please Enter your guess: ");
        while(i<=limit){
            
            int userInput  = sc.nextInt();
            
            //System.out.println(userInput);
            if(userInput == randomNum){
                System.out.println("correct");
                break;
            }
            else if(userInput > randomNum){
                System.out.println("too high");
            }
            else{
                System.out.println("too low");
            }
            i++;

        }
        if(i > limit){
            System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + randomNum );
        }
        
        sc.close();
    }
}