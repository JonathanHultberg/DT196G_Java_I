/**
* Filnamn: PesonCreator.java
* @author Jonathan Hultber (johu1701)
* @version 1.0
* Datum: 2025-03-20
*/

import java.util.ArrayList;
import java.util.Scanner;

public class PersonCreator {
    /**
     * Används för att skapa en ny person i registret.
     * Anropar metoder för att fylla i fält samt skapa signaturer.
     */
    public void addPerson(Scanner inPut, ArrayList<Person> runTimeMem){
        do{
            //Inläsning till fält
            String firstName = readField("firstname", "Firstname of the person: ", inPut);
            String lastName = readField("surname", "Surname of the person: ", inPut);
            String hight = readField("hight", "Persons hight (in centimeter): ", inPut);
            String address = readField("address", "Address: ", inPut);
            String postalCode = readField("postalcode", "Postalcode: ", inPut);
            String city = readField("hometown", "Hometown: ", inPut);

            //Skapar signatur
            String signature = generateSignature(firstName, lastName, runTimeMem);

            //Kontrollerar duplicat
            int duplicatStatus = isDuplicate(firstName, lastName, hight, inPut, runTimeMem);

            //Haterar användarens val ifrån isDuplicate
            if (duplicatStatus == 0){
                runTimeMem.add(new Person(firstName, lastName, signature, hight, address, postalCode, city));
                return;
            } else if (duplicatStatus == 2){
                return;
            }
        } while (true);
    }

    /**
     * Läser in information till fält i person.
     * Anropas i addPerson för att slippa koduppreprning.
     */
    private String readField(String filedName, String promt, Scanner inPut){
        boolean running = true;
        String filed = null;
        char emptyCheck = '\0';

        //do-while för att loopen alltid ska köras minst en gång, ska kunna upprepas ifall felaktig inmatnign sker
        do {
            //Utsktivft av vilket fält som ska fyllas.
            System.out.print(promt);

            //Inläsning
            try {
                filed = inPut.nextLine().trim();
            } catch (Exception e) {
               filed = null;
            }
            
            //Kollar om inmatad sträng är tom, frågar användaren om de ska ersättas med "xxx"
            if (filed.isEmpty() || filed.isBlank()){
                System.out.print("Do you want to leav " + filed + " empty?\n"
                                + "Empty field is replaced whit \"xxx\" (hight will be set to 0)"
                                + "[ Y | N ]: ");
                
                //Inläsning
                try {
                    emptyCheck = inPut.nextLine().charAt(0);
                } catch (Exception e) {
                    emptyCheck = '\0';
                }

                //Val ifall användare vill lämna fält tomt.
                if (emptyCheck == 'y' || emptyCheck == 'Y'){
                    filed = "xxx";
                    running = false;
                }
            } else {
                running = false;
                
            }
        } while (running);

        return filed;
    }

    /**
     * Kontrollerar om en person som ska läggas till är dublicat eller ej.
     * Person anses vara duplikat om för och efternman samt längd är densamma.
     */
    private int isDuplicate(String firstName, String lastName, String hight, Scanner inPut, ArrayList<Person> runTimeMem){
        //Söker genom alla personer som finns i minnet.
        for(Person person: runTimeMem){
            //Kontrollerar om för och efternamn samt längd marchar existerande person.
            if((person.getFirstName().equalsIgnoreCase(firstName.toLowerCase()))
                && (person.getLastName().equalsIgnoreCase(lastName.toLowerCase()))
                && (person.getHight() == Integer.parseInt(hight))){
                    
                int action;
                
                //Ger användaren alternativ.
                System.out.print("The person you are trying to add already exists!\n"
                                    + "Do you want to:\n"
                                    + "1 - Add other person\n"
                                    + "2 - Exit adding process\n"
                                    + "Enter the number corresponding to your desired action > ");
                    
                try {
                    action = Integer.parseInt(inPut.nextLine());
                } catch (Exception e) {
                    action = 0;
                }

                //Switch case för att retunera värde beroende på anvädnarens alernativ.
                switch (action) {
                    case 1:
                        return 1;

                    case 2:
                        return 2;
                    
                    default:
                        break;
                }
        
            }
        }
        
        return 0;
    }

    /**
     * Skapar personens unika signatur.
     * Kallar metoder för att formatera för och efternamn samt för att ge signaturen indexering.
     */
    private String generateSignature(String firsName, String lastName, ArrayList<Person> runTimeMem){
        String signature = formatNamePart(firsName) + formatNamePart(lastName);
        signature = signatureIndex(signature, runTimeMem);
        return signature;
    }

    /**
     * Skapar bas signatur från personens för och efternamn.
     * Om namn är kortare än tre bokstäver fylls de ut med "x".
     */
    private String formatNamePart(String namePart){
        //Byter ut mellanslag mot tom sträng, för att kunna hantera dubble namn.
        namePart = namePart.replaceAll("\\s+", "");

        //Kollar om namnets längd för hur de ska formateras.
        if (namePart.length() >= 3){
            //Extraherar de tre första bokstverna
            namePart = namePart.substring(0, 3);
        } else {
            //Om namn är kortare än 3 bokstäver fylls de ut med "x".
            namePart = namePart + "xxx".substring(namePart.length());
        }

        return namePart.toLowerCase();
    }


    /**
     * Skapar en unik signatur med index för personen baserat på befintliga signaturer.
     * Om signaturer tas bort fylls luckorna igen.
     */
    private String signatureIndex(String baseSignature, ArrayList<Person> runTimeMem){
        // Lista för att lagra alla redan använda index för denna signatur
        ArrayList<Integer> usedIndices = new ArrayList<>();

        // Går igenom alla personer för att hitta matchande signaturer
        for(Person person : runTimeMem){
            String existingSignature = person.getSignature();

            // Säkerställer att signaturen är tillräckligt lång innan vi extraherar index
            if(existingSignature.startsWith(baseSignature) && existingSignature.length() > 6){
                try {
                    // Extraherar indexdelen från signaturen (de två sista siffrorna)
                    String indexStr = existingSignature.substring(6); 
                    int currentIndex = Integer.parseInt(indexStr);
                    usedIndices.add(currentIndex);
                } catch (NumberFormatException e) {
                    // Ignorerar signaturer med felaktigt indexformat
                }
            }
        }

        // Hittar första lediga index (fyller eventuella luckor)
        int newIndex = 1;
        while (usedIndices.contains(newIndex)) {
            newIndex++;
        }

        // Formaterar index med ledande nolla om det är mindre än 10
        String formatedIndex;

        if (newIndex < 10){
           formatedIndex = "0" + Integer.toString(newIndex);
        } else {
            formatedIndex = Integer.toString(newIndex);
        }

        return baseSignature + formatedIndex;
    }
}
