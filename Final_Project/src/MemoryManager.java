/**
* Filnamn: MemoryManager.java
* @author Jonathan Hultber (johu1701)
* @version 1.0
* Datum: 2025-03-20
*/

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MemoryManager {
    //Skapar ett objekt av klassen Encryption för att komma åt krypterings metoder
    Encryption encryptor = new Encryption();

    /**
     * Används för att läsa från minnet (.txt-fil) 
     * Avkrypterar rad för rad innan de läggs till i runTimeMem
     */
    public void readFromMem(ArrayList<Person> runTimeMem, Scanner inPut){
        String fileName;
        int key = 0;

        System.out.print("Enter the name of the file you want to read from, end with \".txt\" > ");
        //Inläsning av vilken fil som ska läsas från
        try {
            fileName = inPut.nextLine();
        } catch (Exception e) {
            fileName = "";
        }

        System.out.print("Enter the encryption key > ");
        //Inläsning av nyckel för avkryptering
        try {
            key = inPut.nextInt();
        } catch (Exception e) {
            key = 0;
        }

        inPut.nextLine(); //Tar bort \n som finns kvar i bufferten efter nextInt()

        //Try-cach för att säkerställa att filen finns och kan öppnas, scanner stängs automatiskt
        try (Scanner inFile = new Scanner(new File(fileName))){
            while(inFile.hasNextLine()){

                //Avkrypterar sträng
                String decryptedLine = encryptor.decrypt(inFile.nextLine(), key);

                //Kontrollerar om formatet är rätt på av krypterad sträng
                if(encryptor.isValidLine(decryptedLine)){
                    //Om sträng är på rätt format delas strängen upp vid DELIM teckent "|". Läggs i en array
                    String[] person = decryptedLine.split("\\|");
                    
                    //Plockar element från array som intparametrar till konstruktorn för skapandet av ett nytt Person objekt
                    runTimeMem.add(new Person(person[0], person[1], person[2], person[3],
                                            person[4], person[5], person[6]));
                } else {
                    //Om formatet är fel på avkrypterad sträng informeras användaren om det
                    System.out.println("Something went wrong while decrypting the file!\n"
                                    + "Either the wrong key was used or the file is corupted"
                                    + "Read from memory will be stoped, press ENTER to continue...");
                    inPut.nextLine();
                    return; //Return för att hoppa ur metoden
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred. File not found: " + fileName);
            e.printStackTrace();
        }
    }

    /**
     * Används för att skriva till minnet (.txt-fil)
     * Peronens infromation plockas från runTimeMem, formateras med DELIM "|"
     * och krypteras.
     */
    public void writeToMem(ArrayList<Person> runTimeMem, Scanner inPut){
        String fileName;
        int key = 0;

        System.out.print("Enter the name of the file you want to save to, end with \".txt\" > ");
        //Inläsning av vilken fil som det ska skrivas till
        try {
            fileName = inPut.nextLine();
        } catch (Exception e) {
            fileName = "";
        }

        System.out.print("Enter the encryption key > ");
        //Inläsning av nyckel som ska användas för kryptering av filen
        try {
            key = inPut.nextInt();
        } catch (Exception e) {
            key = 0;
        }

        inPut.nextLine(); //Tar bort \n som finns kvar i bufferten efter nextInt()

        //Try-cach för att säkerställa att fil kan öppnas, finns ej filen skapas den
        try (FileWriter outFile = new FileWriter(new File(fileName))){
            //Loopar genom alla personer i runTimeMem
            for(Person person: runTimeMem){
                //Skriver ut till filen. Formaterar sträng med DELIM "|" samt krypterar inte utskrift i fil
                outFile.write(encryptor.encrypt(person.getFirstName() + "|" + person.getLastName() + "|"
                + person.getSignature() + "|" + person.getHight() + "|" 
                + person.getAddress() + "|" + person.getPostalCode() + "|" 
                + person.getCity(), key) + "\n");
            }
        } catch (Exception e) {
            System.out.println("An error occurred. File not found: memory.txt");
            e.printStackTrace();
        }
    }
}
