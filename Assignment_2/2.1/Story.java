/**
* Filnamn: Story.java
* @author Jonathan Hultber
* @version 1.0
* Datum: t.ex 2025-01-28
*
* Beskrivning:
* Programmet tar emot svar till promter från användaren och skriver sedan en berättlese med dessa prometer.
*/

import java.util.Scanner;
import java.nio.charset.StandardCharsets;

public class Story {

    public static void main(String[] args)  {

        Scanner inPut = new Scanner(System.in, StandardCharsets.UTF_8);
        String name, livingWith, siblings, where, carrying1, carrying2, specialDay;

        System.out.println("\n\nHej, jag ska berätta en historia skapad just för dig!\n"
                        + "Du behöver bara svara på några frågor först!");

        System.out.print("Vad heter myran? ");
        name = inPut.nextLine();

        System.out.print("Vem bor myran med? ");
        livingWith = inPut.nextLine();

        System.out.print("Hur många syskon har myran? ");
        siblings = inPut.nextLine();

        System.out.print("Var någonstans i skogen finns myrstacken? ");
        where = inPut.nextLine();

        System.out.print("Vad bär myran och syskonen in till stacken? ");
        carrying1 = inPut.nextLine();

        System.out.print("Vad mer bär myran och syskonen in till stacken? ");
        carrying2 = inPut.nextLine();

        System.out.print("Vad är det för speciell dag som gör att myran är ledig? ");
        specialDay = inPut.nextLine();

        System.out.println("\n\nDen lilla myran " + name + "\n\n"
                         + "Det var en gång en liten, liten myra som bodde med sin " + livingWith +" och sina\n"
                         + siblings + " syskon i en myrstack, vid en stor " + where + " i skogen. Den lilla\n"
                         + "Myran hette " + name + ". För det mesta brukade " + name + " och hens syskon arbeta\n"
                         + "med att bära in " + carrying1 + " och " + carrying2 + " till stacken, men idag var det " + specialDay + ",\n"
                         + "så därför var " + name + " ledig.\n\n");

        inPut.close();

    }
}