import java.util.Scanner;
/**
* Filnamn: GuessTheNumber.java
* @author Jonathan Hultber
* @version 1.0
* Datum: t.ex 2025-02-04
*
* Beskrivning:
* Här defineras klassen GuessTheNumber som används i filerna Game.java
* Definition av metoder som används för att sätta max och min samt för körning av spelet
*/
public class GuessTheNumber{
    //Deklarering av instansvariabler
    private int max, min;
    private int target;
    private int guess;
    private int counter = 0;
    private String guessString;
    private String exit = "exit";

    /**
     * Beskrivning: Sätter max och min värde utifrån användarens inmatning
     * @param inPut (Av typen Scanner, används för inmatning från användaren)
     */
    public void setMaxMin(Scanner inPut){
    
        System.out.println("\n------------------------------------------\n"
                        + "Jag vill leka gissa nummret!\n"
                        + "Säg mellan vilka nummer jag ska tänka på en siffra!\n"
                        + "Skriv svaret på frågan och avsluta med Enter!");
        
        System.out.print("Vilket är de lägsta talet?: ");
        this.min = inPut.nextInt();

        System.out.print("Vilket är de högsta talet?: ");
        this.max = inPut.nextInt();
        inPut.nextLine(); //För att inPut.nextInt() inte ränsar bufferten från "\n" --> oönskad inmatning som inte görs av användaren
       
        System.out.println("Då kör vi!");

    }

    /**
     * Beskrivning: Själva spelet, en random int bestäms inom intervallet och användare gissar vilket tal som
     * genererats
     * @param inPut (Av typen Scanner, används för inmatning från användaren)
     */
    public void GamePlay(Scanner inPut){
        //Generering av random int
        target = (int)(Math.random()*(max-min+1)) + min;
        
        //Spel loopen
        do {
        System.out.print("\n------------------------------------------\n"
                        + "Nu ska du gissa vilket nummer jag tänker på\n\n"
                        + "Vad är din gissning, avsluta med Enter: ");
        
        guessString = inPut.nextLine();

        if(isInteger(guessString)){
            guess = Integer.parseInt(guessString);
        }else if (guessString.equals(exit)){
            return;
        }

        counter++; 

        if ((guess < min) || (guess > max)){
            System.out.format("Du är untanför intervallet som är från %d till %d!%n", min, max);
        } else if (guess < target){
            System.out.println("För lågt, pröva ett högre tal!");
        } else if (guess > target){
            System.out.println("För högt pröva ett lägre tal!");
        }

        } while (guess != target);

        System.out.format("Grattis!! Du gissade rätt! Jag tänkte på %d och du gissade %d!%n%n"
                        + "Det tog %d gissnagar för dig!%n", target, guess, counter);
        System.out.println("Programmet kommer nu avslutas!\n");
        
    }
   
    /**
     * Beskrivning: Kontrollerar så att användarens inmatade gissning är en int
     * @param guessString (Av typen String, gissningen från användaren, används för att säkerställa att de är int)
     */
    private boolean isInteger(String guessString){
        return guessString.matches("-?\\d+");
    }

}