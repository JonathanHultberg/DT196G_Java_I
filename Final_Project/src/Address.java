/**
* Filnamn: Address.java
* @author Jonathan Hultber (johu1701)
* @version 1.0
* Datum: 2025-03-20
*/

/**
* Klass som används i klassen Person och innehåller infromation om personens adress
*/
public class Address {
    private String address;
    private String postalCode;
    private String city;

    public Address(){

    }

    public Address(String address, String postalCode, String city){
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
    }
    
    public void setAddress(String address){
        this.address = address;
    }

    public void setPostalCode(String postalCode){
        this.postalCode = postalCode;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getAdress(){
        return address;
    }

    public String getPostalCode(){
        return postalCode;
    }

    public String getCity(){
        return city;
    }
}
