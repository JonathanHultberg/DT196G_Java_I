/**
* Filnamn: Person.java
* @author Jonathan Hultber (johu1701)
* @version 1.0
* Datum: 2025-03-20
*/

/**
* Klass som används för att skapa objekt i forma av personer i registret.
* Innehåller ett objekt av klassen Address
*/
public class Person {
    private String firstName;
    private String lastName;
    private String signature;
    private int hight;
    private Address address = new Address();

    public Person (){
        
    }

    public Person (String firstName, String lastName, String signature, String hight, String address, String postalCode, String city){
        setFirstName(firstName);
        setLastName(lastName);
        setSignature(signature);
        setHight(hight);
        setAddress(address, postalCode, city);
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setSignature(String signature){
        this.signature = signature;
    }

    public void setHight(String height){
        //Kontrollerar ifall användaren vill lämna fältet längd tomt
        if (height.equals("xxx")){
            this.hight = 0;
        } else {
            try {
                this.hight = Integer.parseInt(height);
            } catch (Exception e) {
                this.hight = 0;
            }
        }
    }

    public void setAddress(Address address){
        this.address = address;
    }

    public void setAddress(String address, String postalCode, String city){
        this.address.setAddress(address);
        this.address.setPostalCode(postalCode);
        this.address.setCity(city);
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getSignature(){
        return signature;
    }

    public int getHight(){
        return hight;
    }

    public String getAddress(){
        return address.getAdress();
    }

    public String getPostalCode(){
        return address.getPostalCode();
    }

    public String getCity(){
        return address.getCity();
    }

    //Overridad metod för att underlätta vid utskrift
    @Override
    public String toString(){
        return String.format("%-10s %-30s %4.2f", signature, (firstName + " " + lastName), (hight/100.0));
    }
}