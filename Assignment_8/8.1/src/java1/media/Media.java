package java1.media;
/**
* Filnamn: Media.java
* @author Jonathan Hultber
* @version 1.0
* Datum: t.ex 2025-01-29
*
* Beskrivning:
* Här defineras superklassen Media som ärvs från till Book.java, CD.java och DVD.java
*/
public class Media {
    protected String title;
    protected int length;
    protected Publisher publisher = new Publisher();

    public Media() {
    }

    public Media(String title, int length, Publisher publisher){
        this.title = title;
        setLength(length);
        this.publisher = publisher;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setLength(int length){
        if (length < 0){
            this.length = 0;
        } else {
            this.length = length;
        }
    }

    public void setPublisher(Publisher publisher){
        this.publisher = publisher;
    }

    public void setPublisher(String name, String phoneNR){
        publisher.setName(name);
        publisher.setPhoneNR(phoneNR);
    }

    public String getTitle(){
        return title;
    }

    public int getLength(){
        return length;
    }

    public Publisher getPublisher(){
        return publisher;
    }

    public void print(){
        System.out.println("Titel: " + title + "\n"
                        + "Name of Publisher: " + publisher.getName() + "\n"
                        + "\n-----------------------------------------------\n");
    }

    @Override
    public String toString(){
        return  "Titel: " + title + "\n"
            + "Name of Publisher: " + publisher.getName() + "\n"
            + "\n-----------------------------------------------\n";
    }
}