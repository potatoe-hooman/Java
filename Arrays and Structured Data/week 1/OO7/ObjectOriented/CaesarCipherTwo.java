
/**
 * Write a description of CaesarCChipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * one key version
 */
public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainkey1;   
    private int mainkey2;
    
    public CaesarCipherTwo(int key1, int key2){
        alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1=alphabet.substring(key1)+alphabet.substring(0,key1);
        shiftedAlphabet2=alphabet.substring(key2)+alphabet.substring(0,key2);
        mainkey1=key1;
        mainkey2=key2;
        System.out.println(" " + mainkey1 +" " + mainkey2);
    }
    
    public String encrypt(String input){
        StringBuilder sb= new StringBuilder(input);
        int length=sb.length();
        for(int i=0;i<length;i++){
            char currChar=sb.charAt(i);
           if(i%2==0){
               //use key 1
                if(Character.isUpperCase(currChar)){
                         int index= alphabet.indexOf(currChar);
                         sb.setCharAt(i, shiftedAlphabet1.charAt(index));
                }
            
                if(Character.isLowerCase(currChar)){
                    int index= alphabet.indexOf(Character.toUpperCase(currChar));
                    sb.setCharAt(i, Character.toLowerCase(shiftedAlphabet1.charAt(index)));
                }
                
           }
           
            if(i%2==1){
               //use key 2
                if(Character.isUpperCase(currChar)){
                         int index= alphabet.indexOf(currChar);
                         sb.setCharAt(i, shiftedAlphabet2.charAt(index));
                }
            
                if(Character.isLowerCase(currChar)){
                    int index= alphabet.indexOf(Character.toUpperCase(currChar));
                    sb.setCharAt(i, Character.toLowerCase(shiftedAlphabet2.charAt(index)));
                }
                
           }
        }
        return sb.toString();
    }
    
    public String decrypt(String input){
        CaesarCipherTwo ccin= new CaesarCipherTwo((26-mainkey1),(26-mainkey2));
        String answer=ccin.encrypt(input);
        return answer;
    }
}
