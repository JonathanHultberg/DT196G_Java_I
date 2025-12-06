/**
* Filnamn: PublisherTest1.java
* @author Jonathan Hultber
* @version 1.0
* Datum: t.ex 2025-01-29
*
* Beskrivning:
* Skapar 3 objekt av typen Publisher, tilldelning av instansvariabler med olika tillvägagångssätt. Sträng literaler använd vid tilldelningn. 
* Infomramtion om förlagen skrivs ut på skärmen med olika tillvägagångsätt.
*/

public class PublisherTest1 {
    public static void main(String[] args) {
        //Objekt 1
        Publisher publisher1 = new Publisher("Interscope Records", "(310) 865-1000"); //Nytt objekt skapas, med literala inparametrar
        
        System.out.println("\n--------------------------------------\n");
        System.out.println(publisher1); //Utskrivft, @Overrid av toString vilket formaterar utskriften till önskad form
        System.out.println("\n--------------------------------------\n");
        
        //Objekt 2
        Publisher publisher2= new Publisher(); //Nytt objekt skapas utan inparametrar (metod-överlagring)

        publisher2.setName("Universal Music Group"); //Sätter namnet med en setter metod, där parametern är literal
        publisher2.setPhoneNR("310-865-4455"); //Sätter telefon med en setter metod, där parametern är literal

        publisher2.print(); //Använder printmedtoden definierad inom kalssen Publisher (Skriver ut i dialogruta)

        //Objekt 3
        Publisher publisher3 = new Publisher(); //Nytt objekt skapas utan inparametrar (metod-överlagring)
        String name = "Sony Music Entertainment"; //Stränf literaler tilldelas till variabler
        String phoneNr = "615-726-8326";

        publisher3.setPhoneNR(phoneNr); //Variabler används som inparameter till setter metoder
        publisher3.setName(name);

        System.out.println("Förlagsinformation\n\nFörlag nummer: " + publisher3.getCountPublisher() 
                            + "\nFörlagets namn: " + publisher3.getName()
                            + "\nFörlagets telefonummer: " + publisher3.getPhoneNR()); //Utskrift som använder sig av getter metoder för att hämta information

        System.out.println("\n--------------------------------------\n");
    }
    
}
