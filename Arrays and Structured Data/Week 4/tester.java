
/**
 * Write a description of tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class tester {
    public void testMostCommonCharIn(){
        FileResource fr = new FileResource();
        VigenereBreaker vb= new VigenereBreaker();
        HashSet<String> dict= vb.readDictionary(fr);
        char most=vb.mostCommonChar(dict);
        System.out.println(most);
    }
    public void testCaesarCipher(){
        int key=7;
        CaesarCipher  cc = new CaesarCipher(key);
        FileResource fr= new FileResource();
        String input = fr.asString();
        System.out.println("Input \n" +input);
        String enc=cc.encrypt(input);
        System.out.println("Encrypted \n" +enc);
        String denc=cc.decrypt(enc);
        System.out.println("Encrypted \n" +denc);
    }
    public void testCaesarCracker(){
        //char mostCommon = 'e';
        //most common caharactar in protuguese is a
        CaesarCracker cck=new CaesarCracker();
        FileResource fr= new FileResource();
        String encMessage = fr.asString();        
        int key=cck.getKey(encMessage);
        String dencMessage = cck.decrypt(encMessage); 
        System.out.println("Decrypted \n"+dencMessage);
    }
    public void testVigenereCipher(){
        int[] key={17,14,12,4};
        VigenereCipher  vc = new VigenereCipher(key);
        FileResource fr= new FileResource();
        String input = fr.asString();
        System.out.println("Input \n" +input);

        System.out.println("Input \n" +vc.toString());
        String enc=vc.encrypt(input);
        System.out.println("Encrypted \n" +enc);
        String denc=vc.decrypt(enc);
        System.out.println("Encrypted \n" +denc);
    }
    public void testSliceString(){
        //FileResource fr= new FileResource();
        //String input = fr.asString();
        VigenereBreaker vb = new VigenereBreaker();
        String slice=vb.sliceString("abcdefghijklm", 4, 5);
        System.out.println(slice);
    }
    public void testTryKeyLength(){
        FileResource fr= new FileResource();
        String input = fr.asString();
        VigenereBreaker vb = new VigenereBreaker();
        int keyLength= 38;
        char cmn='e';
        //String slice=vb.sliceString("abcdefghijklm", 4, 5);
        int[] keys= vb.tryKeyLength(input,keyLength,cmn);
        for(int i=0;i<keys.length;i++){
            System.out.println(keys[i]);
        }
        //FileResource frd=new FileResource();
        //HashSet<String> dict = vb.readDictionary(frd);
        //vb.breakForLanguage(input,dict);
    }
}
