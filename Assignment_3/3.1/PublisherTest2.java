/**
* Filnamn: PublisherTest2.java
* @author Jonathan Hultber
* @version 1.0
* Datum: t.ex 2025-01-29
*
* Beskrivning:
* Skapar 3 objekt av klassen Publisher, tilldelning av instansvariabler sker från användaren via dialogrutor.
* Olika tillvägagånsätt används vid tilldelningen. Informationen skrivs ut med print-metoden definerad i Publisher.java
*/

import javax.swing.JOptionPane;

public class PublisherTest2 {
    public static void main(String[] args) {
        //Objekt 1
        Publisher publisher1 = new Publisher(); //Nytt objekt skapas 

        publisher1.setName(JOptionPane.showInputDialog("Skriv in förlagets namn:")); //Setter metoder används i kombination med dialogrutor för tilldelning
        publisher1.setPhoneNR(JOptionPane.showInputDialog("Skriv in förlagets telefonnummer:"));

        publisher1.print();

        //Objekt 2
        String name = JOptionPane.showInputDialog("Skriv in ett annat förlags namn:"); //Inmatnigen från dialogrutorna mellanlagras i variabler
        String phoneNR =JOptionPane.showInputDialog("Skriv in ett annat förlags telefonnummer:");

        Publisher publisher2 = new Publisher(name, phoneNR); //Variabler använs som inpatametrar till constructorn vid skapande av objekt

        publisher2.print();

        //Objekt 3
        Publisher publisher3 = new Publisher(JOptionPane.showInputDialog("Skriv in ytterligare ett förlagsnamn:"),
                                            JOptionPane.showInputDialog("Skriv in yttrerligare ett förlags telefonummer:")); //Dialogrutor ligger direkt som inparametrar till construktorn vid skapande av objektet

        publisher3.print();

    }
}
