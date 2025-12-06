/**

* Filnamn: Me.java
* @author Jonathan Hultber
* @version 1.0
* Datum: t.ex 2025-01-23
*
* Beskrivning:
* Programmet skapar en instans av klassen MyInfo där information om eleven läggs in och skrivs sedan ut på skärmen.
*/

public class Me {
    public static void main(String[] args) {

        MyInfo Jonathan = new MyInfo();

        Jonathan.name = "Jonathan Hultberg";
        Jonathan.hometown = "Jag kommer från Östersund men har bott i Sundsvall sedan 2017";
        Jonathan.reason = "Jag läser denna kurs i samband med min kandidatutbildning i Datateknik.\n" +
                          "\t\t\t     Jag har jobbat inom sjukvården några år och vill nu pröva något nytt.\n" +
                          "\t\t\t     Valde programmering då det verkade kul och intressant!";

        
        Jonathan.printInfo();
    }
}

class MyInfo {
    String name;
    String hometown;
    String reason;

    public void printInfo() {
        System.out.println("\n\nMitt namn: " + name + "\n");
        System.out.println("Vart jag kommer ifrån: " + hometown + "\n");
        System.out.println("Varför jag läser denna kurs: " + reason + "\n\n");
    }
}
