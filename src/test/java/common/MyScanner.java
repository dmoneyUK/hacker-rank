package common;

import java.util.Scanner;

public class MyScanner {

    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        Scanner scan = new Scanner(System.in);

        /* Declare second integer, double, and String variables. */
        int firstLine = i;
        double secondLine = d;
        String thirdLine = s;
        /* Read and save an integer, double, and String to your variables.*/
        // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.
        firstLine += scan.nextInt();
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        secondLine += scan.nextDouble();
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        thirdLine += scan.nextLine();
        /* Print the sum of both integer variables on a new line. */
        System.out.println(firstLine);

        /* Print the sum of the double variables on a new line. */
        System.out.println(secondLine);
        /* Concatenate and print the String variables on a new line; 
        	the 's' variable above should be printed first. */
        System.out.println(thirdLine);
        scan.close();
    }
}
