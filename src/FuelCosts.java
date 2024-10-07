import java.util.Scanner;

public class FuelCosts {
    public static void main(String[] args) {

        double gasGallons = 0.0;
        double fuelEfficiency = 0.0; //in miles per gallon
        double gasGallonPrice = 0.0;
        boolean done = false;
        String trash = "";


        try (Scanner in = new Scanner(System.in)) { //try auto-closes Scanner at block end to avoid memory leak

            do { //input loop for fuel efficiency
               System.out.print("\nEnter fuel efficiency in miles per gallon: ") ;
               if(in.hasNextDouble()) { //safe to read double value
                   fuelEfficiency = in.nextDouble();
                   in.nextLine();
                   done = true; //end input loop
               }
               else { //not a double so use nextline instead goes to trash
                   trash = in.nextLine();
                   System.out.println("Invalid input. Please enter a number with no units instead.");
               }
            } while(!done);

            done = false;
            do { //input loop for gas price
                System.out.print("Enter the price of gas per gallon: $");
                if(in.hasNextDouble()) { //safe to read double
                    gasGallonPrice = in.nextDouble();
                    in.nextLine(); // clear newline from buffer
                    done = true; //end input loop
                }
                else {
                    trash = in.nextLine();
                    System.out.println("Invalid input. Please enter the price as a number to two decimal points");
                }
            } while(!done);

            done = false;
            do { //input loop for number of gallons in tank
                System.out.print("Enter the capacity of the fuel tank in gallons: ");
                if(in.hasNextDouble()) { //safe to read double
                    gasGallons = in.nextDouble();
                    in.nextLine();
                    done = true;
                }
                else {
                    trash = in.nextLine();
                    System.out.println("Invalid input. Please enter the number of gallons as an integer or float value");
                }
            } while (!done);

            double hundredMilesCost = gasGallonPrice * 100/fuelEfficiency;
            double fullTankDistance = gasGallons * fuelEfficiency;
            System.out.printf("%nIt costs $%,.2f for the vehicle to drive 100 miles", hundredMilesCost);
            System.out.printf("%nThe vehicle can travel %,.1f miles on a full tank of gas", fullTankDistance);

        }
    }
}
