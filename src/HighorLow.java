import java.util.Scanner;
import java.util.Random;

public class HighorLow {
    public static void main(String[] args) {

        int guess = 0;
        int randomNum = 0;
        Random rnd = new Random();
        boolean done = false;
        String trash = "";
        String continueYN = "";

        try (Scanner in = new Scanner(System.in)) { //close Scanner after program concludes to avoid memory leak

            while (!done) { //loop if user indicates they want to continue, generate new random value
                randomNum = rnd.nextInt(10) + 1;

                do { //input loop for guessed value
                    System.out.print("\nGuess an integer [1-10]: ");
                    if(in.hasNextInt()) { // safe to read
                       guess = in.nextInt();
                       in.nextLine();
                       if(guess >= 1 && guess <= 10) { //within valid range of int values, end input loop
                           done = true;
                       }
                       else {// entered an integer but outside valid range
                           System.out.println("Invalid int input. Please enter a value within [1-10]");
                           done = false;
                       }
                    }
                    else {//entered value not an int, not safe to read
                        trash = in.nextLine();
                        System.out.println("Invalid non-integer input. Please enter an integer within [1-10]");
                        done = false;
                    }

                } while(!done);

                //Now we'll check if guessed value is higher, lower, or on the money
                System.out.println("\nThe random number was " + randomNum);
                if(guess == randomNum) {
                    System.out.println("Your guess was on the money!");
                }
                else if (guess < randomNum) {
                    System.out.println("Your guess of " + guess + " was low.");
                }
                else if (guess > randomNum) {
                    System.out.println("Your guess of " + guess + " was high.");
                }

                System.out.print("Would you like to play again? Y/N: ");
                continueYN = in.nextLine();
                if (continueYN.equalsIgnoreCase("Y")) {
                    done = false;
                }
                else {//default to ending program in the event of a misinput
                    done = true;
                }
            }
        }
    }
}
