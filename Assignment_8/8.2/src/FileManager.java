import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileManager {

    public static void readFromFile(ArrayList<AgeGroup> runTimeMem){
        String tempAge, tempMale, tempFemale;

        try(Scanner inPut = new Scanner(new File("befolkning2050.txt"))) {
            while(inPut.hasNextLine()){
                tempAge = inPut.nextLine().trim();
                
                String[] maleArray = inPut.nextLine().trim().split("\\s+");
                tempMale = maleArray[1];
    
                String[] femaleArray = inPut.nextLine().trim().split("\\s+");
                tempFemale = femaleArray[1];
    
                runTimeMem.add(new AgeGroup(tempAge, tempMale, tempFemale));
            }
        } catch (Exception e) {
            System.out.println("An error occurred. File not found: befolkning2050.txt");
            e.printStackTrace();
        }
        
    }

    public static void writeToFile(ArrayList<AgeGroup> runTimeMem){

        try (FileWriter outPut = new FileWriter(new File("outFile.txt"))){

            outPut.write("Age       Quantity\n"
                        + "------------------\n");

            for (AgeGroup group: runTimeMem){
                outPut.write(group.toString() + "\n");
            }

            outPut.write("------------------");
            
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
}
