import java.util.Random;            // importing Random function for values in matrices
import java.util.Scanner;           //get user input with Scanner

public class main {
    // filling matrices with random values
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); //get user input
        System.out.print("Please enter the number of rows for Matrix A: ");
        int Arow = sc.nextInt();
        System.out.print("Please enter the number of columns for Matrix A: ");
        int Acol = sc.nextInt();
        System.out.print("Please enter the number of rows for Matrix B: ");
        int Brow = sc.nextInt();
        System.out.print("Please enter the number of columns for Matrix B: ");
        int Bcol = sc.nextInt();
        sc.close(); //end user input system
        System.out.println();
    
        int[][] A = new int[Arow][Acol];
        int[][] B = new int[Brow][Bcol];
        Random rand = new Random(); //random number generator

        for(int i = 0; i < Arow; i++) { //initializes values in Matrix A
            for(int j = 0; j < Acol; j++) {
                A[i][j] = rand.nextInt(6);
            }
        }

        for(int i = 0; i < Brow; i++) { //initializes values in Matrix B
            for(int j = 0; j < Bcol; j++) {
                B[i][j] = rand.nextInt(6);
            }
        }

        // printing matrix A to console
        System.out.println("Matrix A:");
        for(int i = 0; i < Arow; i++) {
            for(int j = 0; j < Acol; j++) {
                if(j == Acol-1) {
                    System.out.println(A[i][j]); //new line
                } else {
                    System.out.print(A[i][j] + ", ");
                }
            }
        }
        // printing matrix B to console
        System.out.println("\nMatrix B: ");
        for(int i = 0; i < Brow; i++) {
            for(int j = 0; j < Bcol; j++) {
                if(j == Bcol-1) { //new line
                    System.out.println(B[i][j]);
                } else {
                    System.out.print(B[i][j] + ", ");
                }
            }
        }
        System.out.println();

        if(Acol == Brow){ //if valid dimensions for AB product
            matrixMul product = new matrixMul(Arow, Acol, Bcol, A, B);
            matrixMul.firstComputer first = product.new firstComputer(); //initializing objects for threads
            matrixMul.secondComputer second = product.new secondComputer();
            matrixMul.thirdComputer third = product.new thirdComputer();
            matrixMul.fourthComputer fourth = product.new fourthComputer();
            matrixMul.fifthComputer fifth = product.new fifthComputer();
            Thread one = new Thread(first); //creating th threads
            Thread two = new Thread(second);
            Thread three = new Thread(third);
            Thread four = new Thread(fourth);
            Thread five = new Thread(fifth);
            one.start(); //starting the threads
            two.start();
            three.start();
            four.start();
            five.start();
            try{
                one.join(); //waiting for each thread to finish
                two.join();
                three.join();
                four.join();
                five.join();
            }
            catch(InterruptedException e){
                System.out.println("Join not sucessfull.");
            }
                System.out.println("A x B is:");
                product.printResult();
        }
        else {
            System.out.println("Matrices A and B are not elligible for the AB product.");
        }
    }
}