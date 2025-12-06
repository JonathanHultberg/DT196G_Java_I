/**
* Filnamn: PersonCreator.java
* @author Jonathan Hultber (johu1701)
* @version 1.0
* Datum: 2025-03-20
*/

import java.util.Scanner;
import java.util.ArrayList;

/**
* Huvud klassen för person registret
* Innehåller egna metoder men anropar även från andra objekt
*/
public class PersonRegistry {
    //Deklarering av en ArrayList som används som runtimememory
    private ArrayList<Person> runTimeMem = new ArrayList<>();

    //Skapade av objekt för att kunna anropa deras funktioner
    private MemoryManager memory = new MemoryManager();
    private PersonCreator creator = new PersonCreator();
    private SortRegistry sort = new SortRegistry();

    /**
    * Konstruktor i klassen PersonRegisry
    * Anropas vid skapaden av ett objekt, skriver ut välkomsttext samt andropar meny metoden
    */  
    public PersonRegistry(){
        System.out.println("\n------------------------\n" 
                        + "Welcome to the Regestry!"
                        + "\n------------------------\n");

        menu();
    }

    /**
    * Menyn för person registret 
    * Anropar metoder utifrån användarens önskemål
    */
    private void menu() {
        boolean running = true;
        //Scanner för hantering av inmatning av användaren
        Scanner inPut = new Scanner(System.in);
    
        do {
            int action;

             System.out.println("===== Registry Menu =====\n" 
                            + "Currently, there are [" + runTimeMem.size() + "] people in the registry.\n\n"
                            + "Please choose one of the following options:\n"
                            + "1 - Add a person\n"
                            + "2 - View the registry\n"
                            + "3 - Search\n"
                            + "4 - Remove a person from the registry\n"
                            + "5 - Sort the registry\n"
                            + "6 - Save to file\n"
                            + "7 - Read from file\n"
                            + "8 - Exit");
    
            System.out.print("\nEnter the number corresponding to your desired action > ");
            
            //Inmatning för alternativ
            try {
                action = inPut.nextInt();
            } catch (Exception e) {
                action = 0;
            }

            inPut.nextLine(); //Tar bort \n som finns kvar i bufferten efter nextInt()
            
            //Switch-case för hantering av användares val
            switch (action) {
                case 1:
                    System.out.println("\n".repeat(50)); // Rensar konsolen visuellt genom att skriva ut tomma rader
                    creator.addPerson(inPut, runTimeMem);
                    break;
                
                case 2:
                    System.out.println("\n".repeat(50)); // Rensar konsolen visuellt genom att skriva ut tomma rader
                    viweRegistry(inPut);
                    break;
                
                case 3:
                    System.out.println("\n".repeat(50)); // Rensar konsolen visuellt genom att skriva ut tomma rader
                    searchRegistry(inPut);
                    break;
    
                case 4:
                    System.out.println("\n".repeat(50)); // Rensar konsolen visuellt genom att skriva ut tomma rader
                    removeEntry(inPut);
                    break;
    
                case 5: 
                    System.out.println("\n".repeat(50)); // Rensar konsolen visuellt genom att skriva ut tomma rader
                    sort.sortMenu(inPut, runTimeMem);
                    break;
    
                case 6:
                    System.out.println("\n".repeat(50)); // Rensar konsolen visuellt genom att skriva ut tomma rader
                    memory.writeToMem(runTimeMem, inPut);
                    break;
    
                case 7:
                    System.out.println("\n".repeat(50)); // Rensar konsolen visuellt genom att skriva ut tomma rader
                    memory.readFromMem(runTimeMem, inPut); 
                    break;
    
                case 8:
                    running = false; 
                    break;
    
                default:
                    break;
            }
            
            System.out.println("\n".repeat(50));
        } while (running);
    
        inPut.close(); //Stänger scanner när programmet avlsutas
    }    

    /**
     * Används för att lista alla personer som finns i registret.
     * Listar 20 personer åt gången och pausar mellan varje sida.
     */
    private void viweRegistry(Scanner inPut) {
        int pageSize = 20; // Antal personer som visas per sida
        int total = runTimeMem.size(); // Totalt antal personer i registret

        // Loopar över alla personer, 20 åt gången
        for (int i = 0; i < total; i += pageSize) {

            // Skriver ut header för sidan
            System.out.print("-----Person registry-----\nThere are currently [" + runTimeMem.size() + "] people in the registry!\n\n\n"
                + String.format("%-3s %-10s %-30s %-5s", "Nr", "Sign", "Name", "Length [m]") + "\n");

            // Skriver ut varje person på sidan
            for (int j = i; j < Math.min(i + pageSize, total); j++) {
                // Visar personens nummer och information (via toString)
                System.out.println(String.format("%-3s %s", ((j + 1) + "."), runTimeMem.get(j)));
            }

            // Om det finns fler personer kvar att visa, pausa och be användaren trycka ENTER
            if ((i + pageSize) < total) {
                System.err.print("\nPress ENTER to view the next 20 entries...");
                inPut.nextLine();
                // Rensar konsolen visuellt genom att skriva ut tomma rader
                System.out.println("\n".repeat(50));
            } else {
                // Sista sidan – be användaren trycka ENTER för att avsluta
                System.out.println("\nAll entries have been listed, press ENTER to quit...");
                inPut.nextLine();
            }
        }
    }

    /**
     * Används för att söka efter person i registret utifrån deras signatur
     */
    private void searchRegistry(Scanner inPut){
        System.out.print("Enter the signature for the person you want to find\n"
                        +"Enter signatur here [xxxyyyzz] > ");
        //Inmatning av signatur som ska sökas efter
        String searshPhrase = inPut.nextLine().toLowerCase();

        //Loopar genom alla personer som finns i registret
        for (Person person: runTimeMem){
            //Kontrollerar om matchning för sökt signatur finns
            if(person.getSignature().equals(searshPhrase)){
                //Om matchining hittas skrivs informationen ut på skärmen, väntar tills användaren trycker ENTER 
                System.out.print("Sign: " + person.getSignature()
                                + "\nName: " + person.getFirstName() + " " + person.getLastName()
                                + "\nHeight: " + person.getHight() + " cm"
                                + "\nPress ENTER to continue...");

                inPut.nextLine();
                return; //Hoppar ut metoden
            } 
        }
        //Utskrivt som sker ifall ingen matchning hittas, väntat tills användaren trycker ENTER
        System.out.print("Sorry, no match was found for that signature\nPress ENTER to continue...");
        inPut.nextLine();
    }

    /**
     * Används för att ta bort person från registret genom inmatning av signatur
     */
    private void removeEntry(Scanner inPut){
        boolean foundMatch = false; //Variabel för att kontrollera om matchning hittats
        int index = 0; //Index för vart matchning hitta

        System.out.print("Enter the signature for the person you want to remove\n"
                        +"Enter signatur here [xxxyyyzz] > ");
        //Inmatning av sökfras i form av signatur
        String searshPhrase = inPut.nextLine().toLowerCase();

        //Looper genom alla personer i registret
        for (int i = 0; i < runTimeMem.size(); i++){
            //Kontrollerar om matchnig hittas
            if(runTimeMem.get(i).getSignature().equals(searshPhrase)){
                foundMatch = true;
                index = i;
                break; //Hopper ur loop när matchning hittats
            }
        }
        
        //Kontrollerar om matchning hittats
        if(foundMatch){
            char removeAction = '\0';

            //Skriver ut person som hittats information och frågar om användaren är vill ta bort personen
            System.out.println("Do you want to remove this person?\n"
                                + "Sign: " + runTimeMem.get(index).getSignature()
                                + "\nName: " + runTimeMem.get(index).getFirstName() + " " + runTimeMem.get(index).getLastName()
                                + "\nHeight: " + runTimeMem.get(index).getHight() + " cm");
            System.out.print("[ Y | N ] > ");

            //Inläsning av användarens alternativ
            try {
                removeAction = inPut.nextLine().charAt(0);
            } catch (Exception e) {
                removeAction = '\0';
            }

            //Kontrollerar om personen vill tal bort personen
            if ((removeAction == 'y') || (removeAction == 'Y')){
                runTimeMem.remove(index); //Tar bort personen
                //Informerar om att personen är bortagen, väntar till användaren trycker ENTER
                System.out.println("Person have been removed from registry");
                System.out.print("Press ENTER to continue...");
                inPut.nextLine();
            }

        } else{
            //Om ingen matchning hittas informeras användaren om detta, väntar tills användaren trycker ENTER
            System.out.print("Sorry, no match was found for that signature\nPress ENTER to continue...");
            inPut.nextLine();
        }
    }
}
