
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCaesarCipherTwo {
    
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
    
     String halfOfString(String message, int start){
        String everyOther="";
        for(int i =start; i<message.length();i+=2){
            everyOther=everyOther+ message.charAt(i);
        }
        return everyOther;
    }
    
        public int getKey(String s){
        int[] alphaCounter =new int[26];
        int[] freqs = countLetters(s,alphaCounter);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4){
            dkey = 26 - (4 - maxDex);
        }
        return dkey;
    }
    
    public void breakCaesarCipher(String input){
        int dkey1 = getKey(halfOfString(input, 0));
        int dkey2 = getKey(halfOfString(input, 1));
        System.out.println(dkey1 + "\t" + dkey2);
        CaesarCipherTwo a = new CaesarCipherTwo(dkey1, dkey2);
        System.out.println(a.decrypt(input));
    }
    
    void simpleTests(){
        FileResource fr= new FileResource();
        String input=fr.asString();
        
        CaesarCipherTwo cct=new CaesarCipherTwo(21,8);
        String encrypted= cct.encrypt(input);
        System.out.println(encrypted);
        String decrypted= cct.decrypt(encrypted);

        System.out.println(decrypted);
        
        
        /*int[] keys= new int[2];
        keys= breakCaesarCipher(input);
        System.out.println("Keys are" +keys[0] +"\t" +keys[1]);

        CaesarCipherTwo cct2=new CaesarCipherTwo(keys[0],keys[1]);
        String decryptedUsingKeys= cct2.decrypt(input);
        System.out.println(decryptedUsingKeys); */
        
    }
}
