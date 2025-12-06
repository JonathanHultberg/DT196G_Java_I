import java.util.Scanner;

public class CountWord {
    private Scanner inPut = new Scanner(System.in);
    private String inPutString;
    private int charCount, wordCount, sentenceCount;

    public CountWord(){
        setInPutString();
        countChar();
        countWord();
        countSentence();
    }

    public void setInPutString(){

        System.out.print("\n-----------------------------------------------------------------------\n"
                        + "Enter some text that you want me to count characters, words and sentences\n"
                        + "Enter text here> ");
        this.inPutString = inPut.nextLine();
    }

    public void countChar(){
        if((inPutString == null) || (inPutString.trim().isEmpty())){
            this.charCount = 0;
        }else {
            this.charCount = inPutString.length();
        }
    }

    public void countWord(){
        if((inPutString == null) || (inPutString.trim().isEmpty())){
            this.wordCount = 0;
        }else {
            
            String[] words = inPutString.split("\\s+");

            for (String word : words){
                if(!word.isEmpty()){
                    this.wordCount++;
                }
            }
        }
    }

    public void countSentence(){
        if((inPutString == null) || (inPutString.trim().isEmpty())){
            this.sentenceCount = 0;
        }else {
            for (int i = 0; i < inPutString.length(); i++){
                char c = inPutString.charAt(i);

                if((c == '.' || c == '!' || c == '?' || c == '\n')){
                    if(i > 0 && Character.isLetter(inPutString.charAt(i-1))){
                        this.sentenceCount++;
                    }
                }
            }
        }
    }

    public void print(){
        System.out.print("\n-----------------------------------------------------------------------\n"
                        + "The text \"" + inPutString + "\" contains the following:\n"
                        + "Sentences: " + sentenceCount + "\n"
                        + "Words: " + wordCount + "\n"
                        + "Characters: " + charCount 
                        + "\n-----------------------------------------------------------------------\n");
    }
}
