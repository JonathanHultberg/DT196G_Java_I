import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
       String[] names ={"Alice Johansson", "Erik Karlsson", "Sofia Lindgren", "Lars Bergström",
                        "Emma Sjöberg", "Johan Nyström", "Maja Andersson", "Oscar Wiklund",
                        "Elin Ekström", "Axel Holmgren", "Tom Karlsson", "Li Andersson", "Max Wu",
                        "Bo Nyström", "Eli Kim", "Jo Jo"};
        
        ArrayList<String> usernames = Usernames.create(names); 

        Usernames.list(names, usernames);
    }
}
      
