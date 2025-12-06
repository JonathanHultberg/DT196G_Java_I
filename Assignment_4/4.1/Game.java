import java.util.Scanner;

/**
* Filnamn: Game.java
* @author Jonathan Hultber
* @version 1.0
* Datum: t.ex 2025-02-07
*
* Beskrivning:
* Klassen som innehåller main-metoden. Programmet startat här ifrån
*/
public class Game {
    public static void main(String[] args) {
        
        
        Scanner inPut = new Scanner(System.in);
        
        GuessTheNumber game = new GuessTheNumber();
        
        game.setMaxMin(inPut);

        game.GamePlay(inPut);

        inPut.close();

    }
}
