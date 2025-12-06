import java.util.Scanner;

public class MathUtils {

    public static void calculate(Scanner inPut){
        
        double operand1, operand2, answer;
        char operator;

        System.out.print("\n--------------------------------------------------------------------\n"
                        + "To performe this operation you need to enter 2 operands and 1 operator\n");
        
        operand1 = Validation.validDouble(inPut, "Operator 1: ");

        operator =Validation.validChar(inPut, "Operator (+,-,/,*): ");

        operand2 = Validation.validDouble(inPut, "Operand 2: ");

        if (operator == '+'){
            answer = operand1 + operand2;

            System.out.println(operand1 + " + " + operand2 + " = " + answer);
        }
        if (operator == '-'){
            answer = operand1 - operand2;

            System.out.println(operand1 + " - " + operand2 + " = " + answer);
        }
        if (operator == '*'){
            answer = operand1 * operand2;

            System.out.println(operand1 + " * " + operand2 + " = " + answer);
        }
        if (operator == '/'){

            if (!(operand2 == 0)){
                answer = operand1 / operand2;

                System.out.println(operand1 + " / " + operand2 + " = " + answer);
            }
            else {
                System.out.println("Division by 0 is not allowed!");
            }

        }
    }

    public static void isOdd(Scanner inPut){

        int number;

        System.out.print("\n--------------------------------------------------------------------\n"
                        + "Enter a integer value to check if it is odd or not\n");

        number = Validation.validInt(inPut, "Enter integer valur/number: ");

        if (number % 2 == 0){
            System.out.println(number + " is a evan number");
        }
        else if (number % 2 != 0){
            System.out.println(number + " is a odd number");
        }
    }
}
