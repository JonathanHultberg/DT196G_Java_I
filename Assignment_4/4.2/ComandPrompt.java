import java.util.Scanner;
/**
* Filnamn: ComandPrompt.java
* @author Jonathan Hultber
* @version 1.0
* Datum: t.ex 2025-02-10
*
* Beskrivning:
* Här defineras klassen ComandPrompt vilket är en simulering av komandotolken
* Definition av startmetod som avgör vilket kommando användaren matar in för att sedan kalla på
* andra privata metoder för att utföra den önskade uppgiften
*/
public class ComandPrompt {
    //Deklarering och initiering av konstant variabel
    public static final String PROMT = "input>";

    //Deklarering av instansvariabler
    private Scanner inPut = new Scanner(System.in);

    /**
     * Beskrivning: Startar programmet, tar inmatning från användaren och avgör vilken privatmetod som ska 
     * anropas för att utföra önskad uppgift
     */
    public void start(){
        String command;
        do {
            System.out.print("\n" + PROMT + " ");
            command = inPut.nextLine();

            switch(command){
                case "help":
                    help();
                    break;
                case "calc":
                case "calculat":
                    calculate(inPut);
                    break;
                case "odd":
                    isOdd(inPut);
                    break;
                case "hello":
                    helloWorld();
                    break;
                case "repeat":
                    repeat(inPut);
                    break;
                case "q":
                case "quit":
                    System.out.println("\nGoodbye!\n");
                    inPut.close();
                    return; //Avslutar programmet
                default:
                    System.out.println("Unknown command. Type 'help' for a list of commands.");                
            }

        } while (true);
    }

    /**
     * Beskrivning: Utför lättare aritmetiska beräkningar, ber användaren om 2 tal och 1 operator
     * utför beräkningen och presenterar de för användaren
     * @param inPut (Av typen Scanner, används för inmatning från användaren)
     */
    private void calculate(Scanner inPut){
        
        double operand1, operand2, answer;
        char operator;

        System.out.print("\n--------------------------------------------------------------------\n"
                        + "To performe this operation you need to enter 2 operands and 1 operator\n");
        
        //Inmatning av användaren
        operand1 = validDouble(inPut, "Operator 1: ");

        operator = validChar(inPut, "Operator (+,-,/,*): ");

        operand2 = validDouble(inPut, "Operand 2: ");

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

    /**
     * Beskrivning: Tar in ett heltal från användaren och avgör om det är ett heltal eller ej
     * @param inPut (Av typen Scanner, används för inmatning från användaren)
     */
    private void isOdd(Scanner inPut){

        int number;

        System.out.print("\n--------------------------------------------------------------------\n"
                        + "Enter a integer value to check if it is odd or not\n");

        //Inmatning av anvädnaren
        number = validInt(inPut, "Enter integer valur/number: ");

        if (number % 2 == 0){
            System.out.println(number + " is a evan number");
        }
        else if (number % 2 != 0){
            System.out.println(number + " is a odd number");
        }
    }

    private void helloWorld(){
        System.out.println("\n--------------------------------------------------------------------\n\n" 
                        + "Hello World!");
    }

    /**
     * Beskrivning: Ber om en sträng från användaren och ett heltal för hur många gånger det ska skrivas
     * ut på skärmen
     * @param inPut (Av typen Scanner, används för inmatning från användaren)
     */
    private void repeat(Scanner inPut) {

        String str;
        int repeatTimes;

        System.out.print("\n--------------------------------------------------------------------\n"
                        + "Enter a string you want to repeat and how many times it will be printed\n");
        
        System.out.print("Enter a string: ");
        str = inPut.nextLine();

        repeatTimes = validInt(inPut, "Number of times to print string: ");

        int counter = 0;
        while (counter < repeatTimes) {
            System.out.println(str);
            counter++;
        }
    }

    /**
     * Beskrivning: Ger en utskrift av vilka kommandon som finns tillgängliga i programmet och vad
     * det olika kommandona gör
     */
    private void help() {
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



    /**
     * Beskrivning: Validerar inmatningen för double så att inte felaktig inmatning sker
     * @param inPut (Av typen Scanner, används för inmatning från användaren)
     * @param promt (Av typen String, promt som visas innan inmatningen)
     * @return (Retunerar en double när ett giltigt värde matats in)
     */
    private double validDouble(Scanner inPut, String promt){
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

    /**
     * Beskrivning: Validerar inmatningen för char så att inte felaktig inmatning sker
     * @param inPut (Av typen Scanner, används för inmatning från användaren)
     * @param promt (Av typen String, promt som visas innan inmatningen)
     * @return (Retunerar en char när ett giltigt värde matats in)
     */
    private char validChar(Scanner inPut, String promt){
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

    /**
     * Beskrivning: Validerar inmatningen för int så att inte felaktig inmatning sker
     * @param inPut (Av typen Scanner, används för inmatning från användaren)
     * @param promt (Av typen String, promt som visas innan inmatningen)
     * @return (Retunerar en int när ett giltigt värde matats in)
     */
    private int validInt(Scanner inPut, String promt){
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

    public static void main(String[] args) {
        ComandPrompt comandPrompt = new ComandPrompt();
        comandPrompt.start();
    }
}
