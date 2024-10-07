import java.util.Scanner;

public class RectangleInfo {
    public static void main(String[] args) {

        double width = 0.0;
        double height = 0.0;
        double area = 0.0;
        double perimeter = 0.0;
        double diagonalLength = 0.0;
        String trash = "";
        boolean done = false;

        try (Scanner in = new Scanner(System.in)) { //autocloses Scanner after try block to avoid memory leak

            do { //input loop for width
                System.out.print("Enter the width of the rectangle: ");
                if(in.hasNextDouble()) { //value safe to read
                    width = in.nextDouble();
                    in.nextLine();
                    done = true;
                }
                else { // not safe to read, block input
                    trash = in.nextLine();
                    System.out.println("Invalid Input. Please enter a number value for the rectangle's width.");
                }
            } while(!done);

            done = false;
            do { //input loop for height
                System.out.print("Enter the height of the rectangle: ");
                if(in.hasNextDouble()) { //safe to read
                    height = in.nextDouble();
                    in.nextLine();
                    done = true;
                }
                else { //invalid input not safe to read
                    trash = in.nextLine();
                    System.out.println("Invalid Input. Please enter a number value for the rectangle's height.");
                }
            } while(!done);

            area = width * height;
            perimeter = 2 * (width + height);
            diagonalLength = Math.sqrt((width*width) + (height*height));

            System.out.printf("%nRectangle Area: %.2f", area);
            System.out.printf("%nRectangle Perimeter: %.2f", perimeter);
            System.out.printf("%nRectangle Diagonal: %.2f", diagonalLength);
            //note: didn't bother implementing input block for negative values
        }

    }
}
