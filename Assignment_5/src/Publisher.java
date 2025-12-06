/**
* Filnamn: Publisher.java
* @author Jonathan Hultber
* @version 1.0
* Datum: t.ex 2025-01-29
*
* Beskrivning:
* Här defineras klassen Publsiher som används i filerna MediaTest.java
*/
import javax.swing.JOptionPane;

public class Publisher {

    //Deklarering av instansvariabler
    private String name;
    private String phoneNR;
    private static int countPublisher = 0; //Static, kommer vara lika för alla objekt skapade från denna kalss, har värdet av senaste objektet

    /**
     * Beskrivning: Construktormetod utan inparametrar (överlagrad-metod). Metoden ökar countPublisher med 1 vid skapande av objekt
     */
    public Publisher(){
        countPublisher++;
    }

    /**
     * Beskrivning: Construktormetod med inparametrar (överlagrad-metod). Metoden initierar objektets variabler samt ökar coutPublisher med en vid skapande av objekt
     * @param name (Av typen sträng, används för initiering av objektets name variabel)
     * @param phoneNR (Av typen sträng, används för initiering av objektets phooneNR variabel)
     */
    public Publisher(String name, String phoneNR){
        this.name = name;
        this.phoneNR = phoneNR;
        countPublisher++;
    }

    /**
     * Beskrivning: En setter metod för instansvariabeln name
     * @param name (Av typen sträng, används för initiering av objektets name variabel)
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Beskrivning: En setter metod för instansvariabeln name
     * @param phoneNR (Av typen sträng, används för initiering av objektets phoneNR variabel)
     */
    public void setPhoneNR(String phoneNR){
        this.phoneNR = phoneNR;
    }
    
    /**
     * Beskrivning: En getter metod för instansvariabeln name
     * @return (Av typen sträng, retunerar privata name variabeln från objektet)
     */
    public String getName(){
        return name;
    }

    /**
     * Beskrivning: En getter metod för instansvariabeln phoneNR
     * @return (Av typen sträng, retunerar privata phoneNR variabeln från objektet)
     */
    public String getPhoneNR(){
        return phoneNR;
    }

    /**
     * Beskrivning: En getter metod för instansvariabeln countPublisher
     * @return (Av typen int, retunerar privata countPublisher variabeln från objektet)
     */
    public int getCountPublisher(){
        return countPublisher;
    }

    /**
     * Beskrivning: print-metod för klassen Publisher, använder dialogruta för att presentera information om förlaget för användaren. Inga inparametrar
     */
    public void print() {
        JOptionPane.showMessageDialog(null, "Förlagnummer: " + countPublisher + "\nNamn: " + name + "\nTelefonnummer: " + phoneNR, "Förlagsinfomration", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Beskrivning: En Overrid för toString som automatisk anropas vid använding av System.out.print och .println
     *              Funktionen formaterar information om förlaget som sedan skrivs ut till användaren
     * @return (Retunerar en sträng formaterat till önskad form)
     */
    @Override
    public String toString(){
        return "Förlagsinformation\n\nFörlagsnummer: " + countPublisher + "\nNamn: " + name + "\nTelefonummer: " + phoneNR;
    }
}