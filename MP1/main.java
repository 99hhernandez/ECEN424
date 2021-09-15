import java.util.Scanner;       // import Scanner class for user input
import java.lang.System;        // for printing to console
import java.util.InputMismatchException;

public class main {
    public static void main(String[] args) {
        Calculator mycalc=new Calculator();         // create new Calculator object called mycalc
        mycalc.setname("Group 12");                 // setting mycal name to Group 12
        Scanner userInput=new Scanner(System.in);   // gets math operation from user
        String op = "";                             // defined to parse user's math operation
        // decalring math arguments
        float A = 0;
        float B = 0;
        float ans = 0;
        while(true) {                               // loop user input until 'Q'
            // printing out instruction lines
            System.out.println("Welcome to the Calculator designed by " + mycalc.getname() + ".");
            System.out.println("Enter A to Add, S to Subtract, M to Multiply, and Q to quit.");

            try {
                op = userInput.nextLine();
                if((op.equals("A") || op.equals("S") || op.equals("M") || op.equals("Q"))) {
                    if(op.equals("Q")) {                    // check if input == Q
                        break;                              // exit loop if true
                    } 
        
                    try {                                   // check input arguments are float values
                        // ask user for both arguments
                        System.out.println("Enter argument 1: ");
                        A = Float.parseFloat(userInput.nextLine());
                        System.out.println("Enter argument 2: ");
                        B = Float.parseFloat(userInput.nextLine());
                    } catch(NumberFormatException e) {                  // print to console for invalid input values
                        System.out.println("Number entered is not a float.\n");
                    }
        
                    switch(op) {                            // operation act based on user input
                        case "A":                           // addition
                            ans = mycalc.addition(A, B);
                            System.out.println("The sum of " + A + " and " + B + " is " + ans + "\n");
                            break;
                        case "S":                           // subtraction
                            ans = mycalc.subtraction(A, B);
                            System.out.println("The difference of " + A + " and " + B + " is " + ans + "\n");
                            break;
                        case "M":                           // multiplication
                            ans = mycalc.multiplication(A, B);
                            System.out.println("The product of " + A + " and " + B + " is " + ans + "\n");
                            break;
                    }
                }
                else {
                    throw new InputMismatchException();
                }
            } catch(InputMismatchException e) {
                System.out.println("Invalid operation input.\n");
            }            
        }
        System.out.println("Goodbye.");
        userInput.close();
    }
}
