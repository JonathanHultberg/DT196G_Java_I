import java.util.ArrayList;


public class App {
    public static void main(String[] args) throws Exception {
        
        ArrayList<AgeGroup> runTimeMem = new ArrayList<>();

        FileManager.readFromFile(runTimeMem);
        FileManager.writeToFile(runTimeMem);

        System.out.println("Age       Quantity\n"
                        + "------------------");
        for (AgeGroup group: runTimeMem){
            System.out.println(group);
        }

        System.out.println("------------------");
    }
}
