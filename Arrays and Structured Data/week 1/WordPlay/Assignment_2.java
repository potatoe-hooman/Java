
/**
 * Write a description of Assignment_2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */  
import edu.duke.*;
import java.io.*;
//Ceasar Cipher
public class Assignment_2 {
  
    public String encrypt(String input, int key){
        StringBuilder sb=new StringBuilder();
        sb.append(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetx="abcdefghijklmnopqrstuvwxyz";
        String modAlphabet=alphabet.substring(key)+alphabet.substring(0,key);
        String modAlphabetx=alphabetx.substring(key)+alphabetx.substring(0,key);
        int length = input.length();
        for(int i=0;i<length;i++){
            char curr=sb.charAt(i);
            int TR= alphabet.indexOf(curr);
            int tr=alphabetx.indexOf(curr);
               if(Character.isUpperCase(curr))
         {
            int index=alphabet.indexOf(curr);
            sb.setCharAt(i,modAlphabet.charAt(index));
         }
         
         if(Character.isLowerCase(curr))
         {
            int indexx=alphabetx.indexOf(curr);
            sb.setCharAt(i,modAlphabetx.charAt(indexx));
         }
        
      
            
      }

        return sb.toString();
  }
  
   public String encryptTwoKeys(String input, int key1, int key2){
        StringBuilder sb=new StringBuilder();
        sb.append(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetx="abcdefghijklmnopqrstuvwxyz";
        String modAlphabet=alphabet.substring(key1)+alphabet.substring(0,key1);
        String modAlphabetx=alphabetx.substring(key1)+alphabetx.substring(0,key1);
        String modAlphabetz=alphabet.substring(key2)+alphabet.substring(0,key2);
        String modAlphabetxz=alphabetx.substring(key2)+alphabetx.substring(0,key2);
        int length = input.length();
        for(int i=0;i<length;i++){
            char curr=sb.charAt(i);
         if(i%2==0){
          if(Character.isUpperCase(curr))
         {
            int index=alphabet.indexOf(curr);
            sb.setCharAt(i,modAlphabet.charAt(index));
         }
         
         if(Character.isLowerCase(curr))
         {
            int indexx=alphabetx.indexOf(curr);
            sb.setCharAt(i,modAlphabetx.charAt(indexx));
         }
        }
        
         if(i%2==1){
          if(Character.isUpperCase(curr))
         {
            int index=alphabet.indexOf(curr);
            sb.setCharAt(i,modAlphabetz.charAt(index));
         }
         
         if(Character.isLowerCase(curr))
         {
            int indexx=alphabetx.indexOf(curr);
            sb.setCharAt(i,modAlphabetxz.charAt(indexx));
         }
        }
        
      }
            System.out.println(sb.toString());
        return sb.toString();
  }
  public void testEncrypt(){
      FileResource fr = new FileResource();
      String message = fr.asString();
      int key=15;
      String encrypted = encrypt(message, key);
      System.out.println("key is " + key + "\n" + encrypted);
      String decrypted = encrypt(encrypted, 26-key);
      System.out.println("\n key is " + (26-key) + "\n" + decrypted);
    }
    
  public void testEncryptTwoKeys(){
      FileResource fr = new FileResource();
      String message = fr.asString();
      int key1=8;
      int key2=21;
      String encrypted = encryptTwoKeys(message, key1,key2);
      System.out.println("key is " + key1 +" " +key2 + "\n" + encrypted);
      String decrypted = encryptTwoKeys(encrypted, 26-key1,26-key2);
      System.out.println("\n key is " + (26-key1)+" " +(26-key2) + "\n" + decrypted);
    }
}
