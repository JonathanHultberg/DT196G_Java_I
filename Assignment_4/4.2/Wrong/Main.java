import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner inPut = new Scanner(System.in);

        TerminalCommand.terminal(inPut);

        inPut.close();

    }
}