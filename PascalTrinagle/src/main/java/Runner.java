import engine.BinomialCoefficients;
import explain.ExplainClass;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        try (Scanner userInput = new Scanner(System.in)) {
            System.out.println("Enter 1 if you need to explain the task or 0 if you don't");
            int choice = userInput.nextInt();
            if (choice == 1)
                new ExplainClass().explain();
            System.out.println("Enter any number less than 2_147_483_648");
            int inputNumber = userInput.nextInt();
            System.out.println("Result : " + BinomialCoefficients.computeBinomialCoefficients(inputNumber));
        }
    }
}
