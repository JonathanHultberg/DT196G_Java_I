/**
* Filnamn: Encryption.java
* @author Jonathan Hultber (johu1701)
* @version 1.0
* Datum: 2025-03-20
*/

public class Encryption {
    //Eget alfabet för att kunna hantera ÅÄÖ samt vissa specialtecken
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖabcdefghijklmnopqrstuvwxyzåäö0123456789|,.!?@#%&";
    //Längden av eget alfabet
    private static final int ALPHABET_LENGTH = ALPHABET.length();
    //Regx för att kunna kontrollera om avkryptrad sträng är på rätt fromat
    private static final String FORMAT_REGEX = "^[^|]+\\|[^|]+\\|[^|]+\\|\\d+\\|[^|]+\\|[^|]+\\|[^|]+$";

    /**
     * Krypterar sträng med cesar schiffer, utifrån nyckel önskad från användaren
     * Kan hanter negativa nyckalar
     */
    public String encrypt(String line, int key){
        //Använder StringBuilder eftersom den är dynamisk. Bättre när man ska bygga en ny sträng karaktär för karaktär
        StringBuilder encryptedLine = new StringBuilder();

        //Loopar genom tecken för tecken i strängen
        for(char c: line.toCharArray()){
            //Extraherar indexen av nuvarande tecken i eget alfabet
            int index = ALPHABET.indexOf(c);
            //Kontrollerar att tecknet faktiskt finns i eget alfabet
            if(index != -1){
                //Om tecken finns får de en ny index, 
                int newIndex = ((index + key) % ALPHABET_LENGTH + ALPHABET_LENGTH) % ALPHABET_LENGTH;
                //Tecken läggs till i krypterad sträng utifrån ny index
                encryptedLine.append(ALPHABET.charAt(newIndex));
            } else {
                //Om tecken inte finns, läggs tecknet till utan att shifta den
                encryptedLine.append(c);
            }
        }

        return encryptedLine.toString();
    }

    /**
     * Avkrypterar sträng med nyckel från användare, använder krypterigen omvänt
     * Kan hantera negativa nycklar
     */
    public String decrypt(String line, int key){
        return encrypt(line, (ALPHABET_LENGTH - (key % ALPHABET_LENGTH)) );    
    }

    /**
     * Används i MemoryManager för att säkerhetskontrollera att avkrypterad sträng är på rätt format
     */
    public boolean isValidLine(String line){
        return line.matches(FORMAT_REGEX);
    }
}
