/**
* Filnamn: SortRegistry.java
* @author Jonathan Hultber (johu1701)
* @version 1.0
* Datum: 2025-03-20
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortRegistry {
    /**
     * Sorterar personer i registret utifrån önskad form av användaren.
     */
    public void sortMenu(Scanner inPut, ArrayList<Person> runTimeMem){
        do {
            int action;
            //Sorterings meny
            System.out.println("===== Sorting Menu =====\n"
                        + "Please choose one of the following sorting options:\n"
                        + "1 - Sort by surname\n"
                        + "2 - Sort by signature\n"
                        + "3 - Sort by length\n"
                        + "4 - Shuffle (random order)\n");

            System.out.print("\nEnter the number corresponding to your desired action > ");

            //Inläsning
            try {
                action = Integer.parseInt(inPut.nextLine());
            } catch (Exception e) {
                action = 0;
            }

            //Switchcase för att hantera användarens val
            switch (action) {
                case 1:
                    System.out.println("\n".repeat(50));
                    //Använder inbyggd sorterings metod, sorterar utifrån efternamnet, om dessa är lika görs de utifrån förnamn
                    runTimeMem.sort(Comparator.comparing(Person :: getLastName).thenComparing(Person :: getFirstName));
                    System.out.print("Sorting is done, press ENTER to continue...");
                    inPut.nextLine();
                    return;
                case 2:
                    System.out.println("\n".repeat(50));
                    //Inbyggd sortering utifrån signaturer
                    runTimeMem.sort(Comparator.comparing(Person :: getSignature));
                    System.out.print("Sorting is done, press ENTER to continue...");
                    inPut.nextLine();
                    return;
                case 3:
                    System.out.println("\n".repeat(50));
                    //Inbyggd sortering utifrån längd
                    runTimeMem.sort(Comparator.comparing(Person :: getHight));
                    System.out.print("Sorting is done, press ENTER to continue...");
                    inPut.nextLine();
                    return;
                case 4:
                    System.out.println("\n".repeat(50));
                    //Inbyggd slumpässig sortering
                    Collections.shuffle(runTimeMem);
                    System.out.print("Sorting is done, press ENTER to continue...");
                    inPut.nextLine();
                    return;
                default:
                    break;
            }
        } while (true);
    }
}
