import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Search {
    private File file;
    private String searchPhrase;
    private int totalLines, searchFound;
    private long elelapsedTime;

    public Search(String fileName) {
        this.file = new File(fileName);
    }

    public void setSearchPhrase(Scanner inputScanner) {

        System.out.println("\n\n");

        do {
            System.out.print("Enter a word you want to search for in the text file\n"
                    + "Enter here> ");
            searchPhrase = inputScanner.nextLine().trim().toLowerCase();

            if (searchPhrase.isEmpty()) {
                System.out.println("Search term cannot be empty! Try again.");
            }
        } while (searchPhrase.isEmpty());
    }

    public void searchFile() {

        long startTime = 0, endTime = 0;

        try (Scanner readFromFile = new Scanner(file)) {
            startTime = System.nanoTime();
            while (readFromFile.hasNextLine()) {
                String line = readFromFile.nextLine().toLowerCase();
                totalLines++;

               
                if (line.contains(searchPhrase)) {
                    searchFound++;
                }
            }
            endTime = System.nanoTime();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. File not found: " + file.getName());
            e.printStackTrace();
        }

        this.elelapsedTime = (endTime - startTime) / 1000000;

    }

    public void print(String fileName){
        if (searchFound == 0){
            System.out.println("The file \"" + fileName +"\" contains " + totalLines + " words\n"
                            + "The word \"" + searchPhrase + "\" does not exists in this file\n"
                            + "The search took " + elelapsedTime + " ms\n\n");
        } else {
            System.out.println("The file \"" + fileName +"\" contains " + totalLines + " words\n"
                            + "The word \"" + searchPhrase + "\"  exists in this file and occurs " + searchFound + " times\n"
                            + "The search took " + elelapsedTime + " ms\n\n");
        }
    }
}
