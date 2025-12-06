/**
* Filnamn: DVD.java
* @author Jonathan Hultber
* @version 1.0
* Datum: t.ex 2025-02-12
*
* Beskrivning:
* Här defineras klassen DVD som används i filerna MediaTest.java och är ärvd av Media superklassen
*/
public class DVD extends Media {
    private int ageLimit;

    public DVD(){
    }

    public DVD(String title, int length, Publisher publisher, int ageLimit){
        super(title, length, publisher);
        setAgeLimit(ageLimit);
    }

    public void setAgeLimit(int ageLimit){
        if (ageLimit < 0) {
            this.ageLimit = 0;
        } else {
            this.ageLimit = ageLimit;
        }
    }

    public int getAgeLimit(){
        return ageLimit;
    }

    public String getLengthAsString(){

        int totalSeconds = length;
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;
        
        return String.format("%02dh %02dm %02ds", hours, minutes, seconds);
    }
    
    @Override //Så inte superklassens printmetod anropas
    public void print(){
        System.out.println("Agelimit: " + ageLimit + "\n"
                        + "Lenght: " + getLengthAsString());
        
        super.print();
    }

    @Override
    public String toString(){
        return "Titel: " + title + "\n"
        + "Length: " + getLengthAsString() + "\n"
        + "Agelimit: " + ageLimit + "\n"
        + "---Publisher---\n"
        + "Name: " + publisher.getName() + "\n"
        + "Phone number: " + publisher.getPhoneNR() + "\n"
        + "\n-----------------------------------------------\n";
    }
    

}
