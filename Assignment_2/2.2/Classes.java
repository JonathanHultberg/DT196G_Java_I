/**
* Filnamn: Classes.java
* @author Jonathan Hultber
* @version 1.0
* Datum: t.ex 2025-01-28
*
* Beskrivning:
* Programmet bygger på en klass vid namnet Course, vilket innehåller informationen av olika kurser.
* Två nya instanser av klassen skapas, ena med literala värden och andra med användarinmatning i form
* av dialogruta. Båda kursernas information skrivs ut i en dialogruta.
*/

import javax.swing.JOptionPane;

public class Classes {
    public static void main(String[] args) {
        
        //Nytt objekt av klassen Course, med hårdkodade/literala värden
        Course course1 = new Course();

        course1.setName("Java I, Datateknik GR (A)");
        course1.setCode("DT196G");
        course1.setCredit("7.5");
        course1.setDescription("En grundläggande programmeringskurs inom den objektorienterade paradigmet." 
                + " Kursen användersig av java som språk och ger därav en grundlig förståelse av dess syntax");
        
        course1.printCourse();

        //Nytt objekt av klassen Course, med värden inmatad från användaren
        Course course2 = new Course();

        course2.setName(JOptionPane.showInputDialog("Vad är kursens namn?"));
        course2.setCode(JOptionPane.showInputDialog("Vilken kod har kursen?"));
        course2.setCredit(JOptionPane.showInputDialog("Hur många högskolepoäng är kursen (skriv utan HP)?"));
        course2.setDescription(JOptionPane.showInputDialog("Skriv en kort beskrivning av kursen?"));

        course2.printCourse();

    }
}    