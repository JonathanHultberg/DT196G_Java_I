import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String fileName = "wordlist1.txt";

        if(args.length > 0){
            fileName = args[0];
        }

        Scanner inPut = new Scanner(System.in);

        Search search = new Search(fileName);

        search.setSearchPhrase(inPut);

        search.searchFile();

        search.print(fileName);

        inPut.close();
    }
}
