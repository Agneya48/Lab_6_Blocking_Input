import java.util.Scanner;

public class CtoFConverter {
    public static void main(String[] args) {

        double cTemp = 0.0; //temperature in Celsius to be entered
        double fTemp = 0.0; //teperature in Fahrenheit that will be calculated
        boolean done = false;
        String trash = "";
        String continueYN = "";

        try (Scanner in = new Scanner(System.in)) { // try auto-closes Scanner so there's no memory leak

            do {
                System.out.print("\nEnter a temperature value in Celsius: ");
                if(in.hasNextDouble()) { //safe to read in a double
                    cTemp = in.nextDouble();
                    in.nextLine(); //clears the newline from buffer
                    fTemp = 1.8 * cTemp + 32;
                    System.out.printf("%.2f degrees Celsius is equal to %.2f degrees Fahrenheit.", cTemp, fTemp);
                    //rounding double values to 2 decimal places to avoid occasional odd double value displays
                    System.out.print("\nWould you like to continue? Y/N: ");
                    continueYN = in.nextLine();
                    if(continueYN.equalsIgnoreCase("Y"))
                        done = false; //ask for another input if user says they want to continue
                    else // typo or user saying they don't want to continue will terminate input loop
                        done = true;
                }
                else { //not a double so use nextLine instead to read a String
                    trash = in.nextLine();
                    System.out.println("Invalid input. Please enter a number instead.");
                }
            } while(!done);
        }
    }
}