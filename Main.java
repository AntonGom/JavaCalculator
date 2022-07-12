import java.util.Scanner;
import java.io.*;

//Made by Antonio Gomez 2021

public class Main
{
    public static void main(String[] args) throws UnknownOperatorException, DivisionByZeroException
    {
                try {
                    calculator();
                }
                catch (Exception e)
                {
                    System.out.println("The following error has occurred "+e);
                }

    }


    public static void calculator() throws UnknownOperatorException, DivisionByZeroException {
        Scanner keyboard = new Scanner(System.in);
        String repeat;

        do {
            double previousResult = 0.0;
            double result = 0.0;

            System.out.println("Calculator is on! Enter an operator followed by a number");
            System.out.print(result+"");
            String userInput = "";

            for (int i = 1; i < 5;) {
                userInput = keyboard.nextLine();

                if (userInput.equalsIgnoreCase("r")) {
                    System.out.println("Final Result = " + result);
                    break;
                }


                double userNumber = Double.parseDouble(userInput.substring(1));
                char userOperator = userInput.charAt(0);


                if (userOperator == '+') {
                    System.out.print(result + " " + userOperator + " " + userNumber + " = ");
                    previousResult = result;
                    result = previousResult + userNumber;
                    System.out.print(result + "\n");
                    System.out.print("new result = "+result);

                } else if (userOperator == '-') {
                    System.out.print(result + " " + userOperator + " " + userNumber + " = ");
                    previousResult = result;
                    result = previousResult - userNumber;
                    System.out.print(result + "\n");
                    System.out.print("new result = "+result);

                } else if (userOperator == '*') {
                    System.out.print(result + " " + userOperator + " " + userNumber + " = ");
                    previousResult = result;
                    result = previousResult * userNumber;
                    System.out.print(result + "\n");
                    System.out.print("updated result = "+result);

                } else if (userOperator == '/') {

                    try {
                        if (userNumber == 0) {
                            throw new DivisionByZeroException();

                        }
                    }
                    catch (DivisionByZeroException e)
                    {
                        System.out.println(e);

                    }

                    if (userNumber>0) {

                        System.out.print(result + " " + userOperator + " " + userNumber + " = ");
                        previousResult = result;
                        result = previousResult / userNumber;
                        System.out.print(result + "\n");
                        System.out.println("updated result = "+result);
                    }

                } else
                {

                    try
                    {
                        {
                            throw new UnknownOperatorException(userOperator);
                        }
                    }
                    catch (UnknownOperatorException e)
                    {
                        System.out.println(e);
                    }
                }

            }

            System.out.println("Would you like to start again? (y/n)");
            repeat= keyboard.nextLine();

        }
        while (repeat.equalsIgnoreCase("y") || repeat.equalsIgnoreCase("yes"));
    }
}
