public class YatzyTest2 {
    public static void main(String[] args) {
        
        int rounds = 10000000;

        if (args.length > 0) {
            try {
                rounds = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Felaktigt argument! Använd ett heltal för antalet kast.");
                System.exit(1);
            }
        }

        int countYatzy = 0;

        long startTime = System.nanoTime();
        Yatzy yatzy = new Yatzy();

        if (yatzy.isYatzy()){
            countYatzy++;
        }

        for (int i = 1; i < rounds; i++){
           
            yatzy.rollDisces();
            
            if (yatzy.isYatzy()){
                countYatzy++;
            }
        }
        long endTime = System.nanoTime();

        long elapsedTime = (endTime - startTime)/ 1000000;

        double probabilityPercent = ((double)countYatzy/rounds) * 100.0;


        System.out.println("\n\nRolling the dices " + rounds + "  times... " + elapsedTime + " ms" );
        System.out.printf("Number of yatzy: %d (%.4f%%)\n\n", countYatzy, probabilityPercent);
    }
}
