
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (Sarthak) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class TestCaesarCipher {
    
    private int maxIndex(int[] counter){
        int mega=0;
        int pointer=0;
        for(int i=0; i<counter.length; i++){
         if(mega<counter[i]){
            pointer=i;
            mega=counter[i];            
         }
        }
        return pointer;    
    }
    
    private int[] countLetters(String s,int[] alphaCounter){
        String alphabet="abcdefghijklmnopqrstuvwxyz";
        for(int i=0; i<s.length();i++){
          char ch=Character.toLowerCase(s.charAt(i));
            for(int j=0; j<alphaCounter.length;j++){
                char alphach=alphabet.charAt(j);
                if(ch==alphach){
                    alphaCounter[j]+=1;
                }
            }
         }
        return alphaCounter;
    }
    
    int breakCaesarCipher(String input){
        int key=0;
        int[] Counter=new int[26];
        Counter= countLetters(input,Counter);
        key=maxIndex(Counter);
        System.out.println("Key Found is " +key);
        return key;

    }
    
    void simpleTests(){
        FileResource fr=new FileResource();
        String input=fr.asString();
        int givenKey=15;
        
        CaesarCChipher cc=new CaesarCChipher(givenKey);
        String enc=cc.encrypt(input);
        System.out.println(enc);
        String denc=cc.decrypt(enc);
        System.out.println(denc);
        
        int key=breakCaesarCipher(enc);        
        CaesarCChipher cc2=new CaesarCChipher(key);
        String dencNew = cc2.decrypt(enc);
        System.out.println(dencNew);
    }
    
    
}
