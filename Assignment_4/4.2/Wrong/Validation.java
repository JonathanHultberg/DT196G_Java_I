import java.util.Scanner;

public class Validation {

    public static double validDouble(Scanner inPut, String promt){
        double number;
        while (true) {
            try {
                System.out.print(promt);
                number = inPut.nextDouble();
                inPut.nextLine(); //Rensar buffert från \n
                return number;
            } catch (Exception e) {
                System.out.println("Input must be a number!");
                inPut.nextLine(); //Rensar ogiltig inmatning i bufferten
            } 
        }       
    }

    public static char validChar(Scanner inPut, String promt){
        String str;

        while (true){
            System.out.print(promt);
            str = inPut.nextLine();

            if ((str.length() == 1) && ("+-/*".indexOf(str.charAt(0)) != -1)){
                return str.charAt(0);
            }
            else {
                System.out.println("Invalid operator! Please enter one of +, -, *, or /.");
            }
        }
    }

    public static int validInt(Scanner inPut, String promt){
        int number;
        while (true) {
            try {
                System.out.print(promt);
                number = inPut.nextInt();
                inPut.nextLine(); //Rensar buffert från \n
                return number;
            } catch (Exception e) {
                System.out.println("Input must be a integer");
                inPut.nextLine(); //Rensar ogiltig inmatning i bufferten
            }
        }
    }
    
}
