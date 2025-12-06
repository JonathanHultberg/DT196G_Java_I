import java.util.Arrays;

public class Yatzy {
    
    private int[] dices = new int[5];

    public Yatzy(){
        rollDisces();
    }

    public void rollDisces(){

        for (int i = 0; i <5; i++){
            dices[i] = (int)(Math.random() * 6) + 1 ;
        }
    }

    public void rollDisces(boolean dice1, boolean dice2, boolean dice3, boolean dice4, boolean dice5){
        if(dice1){
            dices[0] = (int)(Math.random() * 6) +1;
        }
        if(dice2){
            dices[1] = (int)(Math.random() * 6) +1;
        }
        if(dice3){
            dices[2] = (int)(Math.random() * 6) +1;
        }
        if(dice4){
            dices[3] = (int)(Math.random() * 6) +1;
        }
        if(dice5){
            dices[4] = (int)(Math.random() * 6) +1;
        }
    }

    public boolean isYatzy(){
        if((dices[0] == dices[1]) && (dices[1] == dices[2]) && (dices[2] == dices[3]) && (dices[3] == dices[4])){
            return true;
        } else {
            return false;
        }
    }


    public void sort(){

        Arrays.sort(dices);

        for (int i = 0; i < dices.length / 2; i++) {
            int temp = dices[i];
            dices[i] = dices[dices.length - 1 - i];
            dices[dices.length - 1 - i] = temp;
        }
    }

    @Override
    public String toString(){
        return dices[0] + " " + dices[1] + " " + dices[2] + " " + dices[3] + " " + dices[4];
    }
}
