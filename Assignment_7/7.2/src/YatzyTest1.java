public class YatzyTest1 {
    public static void main(String[] args) throws Exception {
        
        Yatzy gameOfYatzy = new Yatzy();

        System.out.println("\nRolling all the dices...");
        System.out.println(gameOfYatzy + "\n");

        gameOfYatzy.rollDisces(false, false, false, true, true);

        System.out.println("Rolling dices 4 and 5...");
        System.out.println(gameOfYatzy + "\n");

        gameOfYatzy.sort();

        System.out.println("Sorting the dices...");
        System.out.println(gameOfYatzy + "\n");

        System.out.println("Checking for yatzy...");

        if(gameOfYatzy.isYatzy()){
            System.out.println("Yay, " + gameOfYatzy + " is Yatzy!\n");
        } else {
            System.out.println("Sorry, " + gameOfYatzy + " is not Yatzy!\n");
        }
    }
}
