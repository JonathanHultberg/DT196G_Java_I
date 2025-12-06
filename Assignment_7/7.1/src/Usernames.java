import java.util.ArrayList;

public class Usernames {

        public static ArrayList<String> create(String[] names) {
            ArrayList<String> usernames = new ArrayList<>();
    
            for (String name : names) {
                String tempUsername = ""; 
    
                if (name == null || name.trim().isEmpty()) {
                    tempUsername = "null";
                } else {
                    String[] splitName = name.toLowerCase().trim().split("\\s+");
    
                    for (String nameSegment : splitName) {
                        if (nameSegment.length() <= 3) {
                            tempUsername += nameSegment; 
                        } else {
                            tempUsername += nameSegment.substring(0, 3); 
                        }
                    }
                }

                usernames.add(tempUsername); 
            }
    
            return usernames;
        }

        public static void list(String[] names, ArrayList<String> usernames){
            if(names.length != usernames.size()){
                System.out.println("Error: the sizes of the array and ArrayList is not the same!");
            } else {
                System.out.print("\n---------------------------------------\n");

                for (int i = 0; i < names.length; i++){
                    System.out.print(names[i]+" (" + usernames.get(i) + ")\n");
                }
                
                System.out.print("\n---------------------------------------\n");
            }

        }
}
