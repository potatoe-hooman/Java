
/**
 * Write a description of CaesarCChipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * one key version
 */
public class CaesarCChipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainkey;
    
    public CaesarCChipher(int key){
        alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet=alphabet.substring(key)+alphabet.substring(0,key);
        mainkey=key;
    }
    
    public String encrypt(String input){
        StringBuilder sb= new StringBuilder(input);
        int length=sb.length();
        for(int i=0;i<length;i++){
            char currChar=sb.charAt(i);
            if(Character.isUpperCase(currChar)){
               int index= alphabet.indexOf(currChar);
               sb.setCharAt(i, shiftedAlphabet.charAt(index));
           }
            if(Character.isLowerCase(currChar)){
               int index= alphabet.indexOf(Character.toUpperCase(currChar));
               sb.setCharAt(i, Character.toLowerCase(shiftedAlphabet.charAt(index)));
           }
        }
        return sb.toString();
    }
    
    public String decrypt(String input){
        CaesarCChipher cc= new CaesarCChipher(26-mainkey);
        String answer=cc.encrypt(input);
        return answer;
    }
}
