
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarBreaker {
    String decrypt(String encrypted,int key){
   
        Assignment_2 cc= new Assignment_2();
        String message= cc.encrypt(encrypted,26-key);
        return message;
    }
    
    void testDecrypt(){
        FileResource fr= new FileResource();
        String sendThis=fr.asString();
        int key=7;
        String receivedMsg=decrypt(sendThis, key);
        System.out.println("The decrypted message is : " +receivedMsg);       
    }
    
    String halfOfString(String message, int start){
        String everyOther="";
        for(int i =start; i<message.length();i+=2){
            everyOther=everyOther+ message.charAt(i);
        }
        return everyOther;
    }
    
    int[] countLetters(String s,int[] alphaCounter){
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
    
    int maxIndex(int[] counter){
        int mega=0;
        int pointer=0;
        for(int i=0; i<counter.length; i++){
         if(mega<counter[i]){
            pointer=i;
            mega=counter[i];
            
         }
         System.out.println("Magic" +i +" " +counter[i] +" " +mega +" " +pointer);
        }
        return pointer;    
    }
    
    int getKey(String s){
        int[] alphaCounter= new int[26];
        alphaCounter= countLetters(s,alphaCounter);
        int key= maxIndex(alphaCounter);//index of 
        System.out.println("Hence, the max occured alphabet is indexed : " +key);
     
        return key;
    }
    
    void decryptTwoKeys(String encrypted){
        //this encrypted message is with two keys
        String firstHalf=halfOfString(encrypted,0);
        String otherHalf=halfOfString(encrypted,1);
        int key1= getKey(firstHalf);
        int key2= getKey(otherHalf);      
        System.out.println("Key 1 and Key 2 are : " +key1 +"\t and \t" +key2);
 
    }
}
