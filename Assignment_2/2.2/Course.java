/**
* Filnamn: Course.java
* @author Jonathan Hultber
* @version 1.0
* Datum: t.ex 2025-01-28
*
* Beskrivning:
* Här defineras klassen Course som används i filen Classes.java
*/
import javax.swing.JOptionPane;

public class Course {
        
    private String name;
    private String code;
    private String credit;
    private String description;

    public void setName (String name) {
        this.name = name;
    }

    public void setCode (String code) {
        this.code = code;
    }

    public void setCredit (String credit) {
        this.credit = credit;
    }

    public void setDescription (String description) {
        
        //Om den inmatade eller hårdkodade sträng är av längre slag 
        //delas den med \n i ett mellanslag i mitten av strängen
        if(description.length()>= 70){

            int indexMiddle = description.length()/2;
            int breakPoint = description.lastIndexOf(" ", indexMiddle);
            description = description.substring(0, breakPoint) + "\n" + description.substring(breakPoint + 1);
        }

        this.description = description;
    }

    public void printCourse() {

        JOptionPane.showMessageDialog(null,"Kursens namn: " + this.name + "\n"
                                    + "Kurskoden: " + this.code + "\n" + "Kursens högskolepoäng (HP): "
                                    + this.credit + "\n" + "Beskrivning: " + this.description,"Kursinformation", JOptionPane.PLAIN_MESSAGE);
    }
}

