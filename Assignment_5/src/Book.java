/**
* Filnamn: Book.java
* @author Jonathan Hultber
* @version 1.0
* Datum: t.ex 2025-02-12
*
* Beskrivning:
* Här defineras klassen Book som används i filerna MediaTest.java och är ärvd av Media superklassen
*/
public class Book extends Media {
    private String author;

    public Book(){
    }

    public Book(String title, int length, Publisher publisher, String author){
        super(title, length, publisher);
        this.author = author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor(){
        return author;
    }

    public String getLengthAsString(){
        if (length == 1) {
            return String.format("%d page", length);
        } else {
            return String.format("%d pages", length);
        }
    }

    @Override
    public void print(){
        System.out.println("Author: " + author + "\n"
                        + "Length: " + getLengthAsString());
        
        super.print();
    }

    @Override
    public String toString(){
        return "Titel: " + title + "\n"
        + "Length: " + getLengthAsString() + "\n"
        + "Author: " + author + "\n"
        + "---Publisher---\n"
        + "Name: " + publisher.getName() + "\n"
        + "Phone number: " + publisher.getPhoneNR() + "\n"
        + "\n-----------------------------------------------\n";
    }
}
