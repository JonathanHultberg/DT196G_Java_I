/**
* Filnamn: MediaTest.java
* @author Jonathan Hultber
* @version 1.0
* Datum: t.ex 2025-02-12
*
* Beskrivning:
* Main klassen för att testa olika subklasser som har arv från Media.java
*/
public class MediaTest {
    public static void main(String[] args) {
        //DVD 1
        Publisher publisher1 = new Publisher("Warner Bros","066 43542");
        DVD dvd1 = new DVD("Inception",8880, publisher1, 13);

        //DVD 2
        DVD dvd2 = new DVD();

        dvd2.setTitle("The Lion King (1994)");
        dvd2.setLength(5340);
        dvd2.setPublisher("Walt Disney Pictures", "0770 36452");
        dvd2.setAgeLimit(0);

        //Book 1
        Publisher publisher2 = new Publisher();

        publisher2.setName("HarperCollins");
        publisher2.setPhoneNR("0088 53676");
    
        Book book1 = new Book();
        
        book1.setTitle("The Fellowship of the Ring");
        book1.setAuthor("J.R.R. Tolkien");
        book1.setPublisher(publisher2);
        book1.setLength(423);

        //Book 2
        Publisher publisher3 = new Publisher("Penguin Books", "0990 36454");
        Book book2 = new Book("1984", 328, publisher3 , "George Orwell");
        
        //CD 1
        Publisher publisher4 = new Publisher("Interscope","0110 45687");
        CD cd1 = new CD("Born this way", 4080, publisher4, "Lady Gaga");

        //CD 2
        CD cd2 = new CD();

        cd2.setTitle("Midnights");
        cd2.setLength(2760);
        cd2.setPublisher("Republic", "0669 67745");
        cd2.setArtist("Taylor Swift");

        //Utskrift
        System.out.println("\n-----------------------------------------------\n"
                        + "The program currently contains two books with the following titles:\n" 
                        + book1.getTitle() + " and " + book2.getTitle()
                        + "\nAs well as two DVDs: " + dvd1.getTitle() + " and " + dvd2.getTitle()
                        + "\nAnd two CD: " + cd1.getTitle() + " and " + cd2.getTitle()
                        + "\nBelow, essential information about the books, CDs, and DVDs is presented."
                        + "\n-----------------------------------------------\n");

        dvd1.print();
        System.out.println(dvd2);

        System.out.println(book1);
        book2.print();

        cd1.print();
        System.out.println(cd2);

        

    

    }
}
