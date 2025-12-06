import java.util.Scanner;

public class TerminalCommand {

static final String PROMT = "input>";

public static void terminal (Scanner inPut){
    boolean running = true;
    String command;

    
    do {
        System.out.print("\n" + PROMT + " ");
        command = inPut.nextLine();

        switch(command){
            case "help":
                StringUtils.help();
                break;
            case "calc":
            case "calculat":
                MathUtils.calculate(inPut);
                break;
            case "odd":
                MathUtils.isOdd(inPut);
                break;
            case "hello":
                StringUtils.helloWorld();
                break;
            case "repeat":
                StringUtils.repeat(inPut);
                break;
            case "q":
            case "quit":
                running = false;
                System.out.println("\nGoodbye!\n");
                break;
            default:
                System.out.println("Unknown command. Type 'help' for a list of commands.");

                
        }

    } while (running);

}
    
}
