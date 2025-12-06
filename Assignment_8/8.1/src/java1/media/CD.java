package java1.media;
/**
* Filnamn: CD.java
* @author Jonathan Hultber
* @version 1.0
* Datum: t.ex 2025-02-12
*
* Beskrivning:
* Här defineras klassen CD som används i filerna MediaTest.java och är ärvd av Media superklassen
*/
public class CD extends Media {
    private String artist;
    
    public CD(){
    }


    public CD (String title,  int length, Publisher publisher, String artist){
        super(title, length, publisher);
        this.artist = artist;
    }

    public void setArtist(String artist){
        this.artist = artist;
    }

    public String getArtist(){
        return artist;
    }

    public String getLengthAsString(){

        int totalSeconds = length;
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;
        
        return String.format("%02dh %02dm %02ds", hours, minutes, seconds);
    }

    @Override
    public void print(){
        System.out.println("Artist: " + artist + "\n"
                        + "Lenght: " + getLengthAsString());
        
        super.print();
    }

    @Override
    public String toString(){
        return "Titel: " + title + "\n"
        + "Length: " + getLengthAsString() + "\n"
        + "Artist: " + artist + "\n"
        + "---Publisher---\n"
        + "Name: " + publisher.getName() + "\n"
        + "Phone number: " + publisher.getPhoneNR() + "\n"
        + "\n-----------------------------------------------\n";
    }
}