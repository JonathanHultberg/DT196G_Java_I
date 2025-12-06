/**
* Filnamn: CD.java
* @author Jonathan Hultber
* @version 1.0
* Datum: t.ex 2025-02-04
*
* Beskrivning:
* Här defineras klassen CD som används i filerna CDTest.java och PublisherTest2.java
*/

public class CD {

    //Deklarering av instansvariabler
    private String title;
    private String artist;
    private int length;
    private Publisher publisher = new Publisher(); //Vid en ny instans av klassen publisher skapas vid en ny instans av klassen CD

    /**
     * Beskrivning: Construktormetod utan inparametrar (överlagrad-metod).
     */
    public CD(){

    }

    /**
     * Beskrivning: Construktormetod med inparametrar (överlagrad-metod). Metoden initierar objektets variabler
     * @param title (Av typen sträng, används för initiering av objektets title variabel)
     * @param artist (Av typen sträng, används för initiering av objektets artist variabel)
     * @param length (Av typen int, använd för initeiering av objektets length variabel)
     * @param publisher (Objekt av klassen Publisher, används för initiering av objektets publisher vaiabel)
     */
    public CD (String title, String artist, int length, Publisher publisher){
        this.title = title;
        this.artist = artist;
        this.length = length;
        this.publisher = publisher;
    }

    /**
     * Beskrivning: En setter metod för instansvariabeln title
     * @param title (Av typen sträng, används för initiering av objektets title variabel)
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     * Beskrivning: En setter metod för instansvariabeln artist
     * @param artist (Av typen sträng, används för initiering av objektets artist variabel)
     */
    public void setArtist(String artist){
        this.artist = artist;
    }

    /**
     * Beskrivning: En setter metod för instansvariabeln length
     * @param length (Av typen int, används för initiering av objektets length variabel)
     */
    public void setLength(int length){
        this.length = length;
    }

    /**
     * Beskrivning: En setter metod för instansvariabeln publsiher
     * @param publisher (Obejt av klassen publisher, används för initiering av objektets publisher variabel)
     */
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    /**
     * Beskrivning: En setter metod för instansvariabeln name och phoneNR i Publisher objektet
     * @param name (Av typen sträng, används för initiering av Publisher objektets name variabel)
     * @param phoneNR (Av typen sträng, används för initiering av Publisher objektets phoneNR variabel)
     */
    public void setPublisher(String name, String phoneNR){
        publisher.setName(name);
        publisher.setPhoneNR(phoneNR);
    }

    /**
     * Beskrivning: En getter metod för instansvariabeln tile
     * @return (Av typen sträng, retunerar privata title variabeln från objektet)
     */
    public String getTitle(){
        return title;
    }

    /**
     * Beskrivning: En getter metod för instansvariabeln artist
     * @return (Av typen sträng, retunerar privata artis variabeln från objektet)
     */
    public String getArtist(){
        return artist;
    }

    /**
     * Beskrivning: En getter metod för instansvariabeln length
     * @return (Av typen int, retunerar privata length variabeln från objektet)
     */
    public int getLegnth(){
        return length;
    }

    /**
     * Beskrivning: En getter metod för instansvariabeln name
     * @return (Objekt av kalssen Publisher, retunerar privata publisher variabeln från objektet)
     */
    public Publisher getPublisher(){
        return publisher;
    }

    /**
     * Beskrivning: print-metod för klassen CD, använder System.out.println för utskrigften. Inga inparametrar
     */
    public void print(){
        System.out.println("\n\n---------------------------------------------\n"
                            + "Title på albumet: " + title + "\n"
                            + "Artist: " + artist + "\n"
                            + "Albumets längd: " + length + " sekunder\n"
                            + "Förlag: " + publisher.getName()
                            + "\n---------------------------------------------\n");
    }

    /**
     * Beskrivning: En Overrid för toString som automatisk anropas vid använding av System.out.print och .println
     *              Funktionen formaterar information om album och förlaget som sedan skrivs ut till användaren
     * @return (Retunerar en sträng formaterat till önskad form)
     */
    @Override
    public String toString(){
        return "\n\n---------------------------------------------\n"
                + "Title på albumet: " + title + "\n"
                + "Artist: " + artist + "\n"
                + "Albumets längd: " + length + " sekunder\n"
                + "\n---------------------------------------------\n";
    }

}