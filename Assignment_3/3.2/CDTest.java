import java.util.Scanner;

/**
* Filnamn: CDTest.java
* @author Jonathan Hultber
* @version 1.0
* Datum: t.ex 2025-02-04
*
* Beskrivning:
* Skapar 3 instanser av kallsen CD, tilldelning av instansvariabler sker på olika sätt, setter med hårdkodning, construktor med hårdkodning
* samt med variabler med lagrad inmatning från användaren. I slutet skrivs informationen om objekten ut, använder både kalssens print() metod
* samt en @Override toString() metod.
*/
public class CDTest {
    public static void main(String[] args) {
        //Objekt 1 
        CD album1 = new CD(); //Ny instans av klassen CD

        album1.setTitle("Chromatica");  //Setter metoder för tilldelning av instansvariabler
        album1.setArtist("Lady Gaga");
        album1.setLength(2588);
        album1.setPublisher("Interscope Records", "(310) 865-1000");

        //Objekt 2
        Publisher publisher1 = new Publisher("Transgressive Records", "020 7700 4464"); //Ny instans av klassen Publisher
        CD album2 = new CD("Oil of Every Pearl's Un-Insides", "SOPHIE", 2395, publisher1); //Tilldelning av instansvariabler med construktorn

        //Objekt 3
        CD album3 = new CD(); //Ny instans av klassen CD
        
        //Deklaration av variabler för inmatning av information
        String title;   
        String artist;
        int length;
        String publisherName;
        String publisherNumber;

        //Inmatning av användaren till variablerna
        System.out.println("\nMata in information om albumet (avsluta med Enter)\n"
                            + "\n------------------------------------------------\n");
        
        Scanner inPut = new Scanner(System.in);

        System.out.print("Albuments titel: ");
        title = inPut.nextLine();

        System.out.print("Artistens namn: ");
        artist = inPut.nextLine();

        System.out.print("Albumets längd (i sekunder): ");
        length = Integer.parseInt(inPut.nextLine());

        System.out.print("Förelagets namn: ");
        publisherName = inPut.nextLine();

        System.out.print("Förlagets telefonnummer: ");
        publisherNumber = inPut.nextLine();

        inPut.close(); //Stänger scanner objektet

        album3.setTitle(title); //Setter metoder för att tilldela instansvariabelrna
        album3.setArtist(artist);
        album3.setLength(length);
        album3.setPublisher(publisherName,publisherNumber);


        //Utskrift av infomrmation
        System.out.println("\n" + album1);
        
        album2.print();

        System.out.println("\n" + album3);



    }
    
}
