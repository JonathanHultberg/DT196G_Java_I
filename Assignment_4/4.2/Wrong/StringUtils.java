import java.util.Scanner;
public class StringUtils {

    public static void helloWorld(){
        System.out.println("\n--------------------------------------------------------------------\n\n" 
                        + "Hello World!");
    }

    public static void repeat(Scanner inPut) {

        String str;
        int repeatTimes;

        System.out.print("\n--------------------------------------------------------------------\n"
                        + "Enter a string you want to repeat and how many times it will be printed\n");
        
        System.out.print("Enter a string: ");
        str = inPut.nextLine();

        repeatTimes = Validation.validInt(inPut, "Number of times to print string: ");

        int counter = 0;
        while (counter < repeatTimes) {
            System.out.println(str);
            counter++;
        }
    }

    public static void help() {
        System.out.print("\n--------------------------------------------------------------------\n"
                        + "calculate    Perform a simple mathematical calculation\n"
                        + "calc         Same as 'calculate'\n"
                        + "helloe       Prints greeting to screen\n"
                        + "odd          Checks if a certain number is odd or even\n"
                        + "repeat       Repeats a string a certain number of times\n"
                        + "quit         Quit the program\n"
                        + "q            Quit the program"
                        + "\n--------------------------------------------------------------------\n");
    }
    
}
