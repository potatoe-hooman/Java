import java.util.*;
import edu.duke.*;
import java.io.*;
public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        //whichSlice indicate startfrom
        //totalSlices is length of key
        String output="";
        StringBuilder input=new StringBuilder(message);
        for(int i=whichSlice; i<input.length();i+=totalSlices){
            output+=message.charAt(i);
        }

        return output;
    }
    public char mostCommonChar(HashSet<String> dict){
      
        HashMap<Character,Integer> charArr_Count= new HashMap<Character,Integer>();
        for(String str: dict){
            for(int j=0;j<str.length();j++){
                char currChar =Character.toLowerCase(str.charAt(j));
                if(!charArr_Count.containsKey(currChar)){
                    charArr_Count.put(currChar,1);
                }
                else{
                    int hululu=charArr_Count.get(currChar);
                    charArr_Count.put(currChar, hululu+1);
                }

            }
        }
        int max=0; char mostCommon='a';
        for(char el:charArr_Count.keySet()){
            int currCount=charArr_Count.get(el);
            if(max<currCount){
                max=currCount;
                mostCommon =el;
            }
        }
        return mostCommon;        
    }
    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        // keyLength is the size
        int[] key = new int[klength];
        //WRITE YOUR CODE HERE
        CaesarCracker cc = new CaesarCracker(mostCommon);
        for(int i=0; i<klength;i++){
            String currS=sliceString(encrypted,i,klength);
            //System.out.println(currS);
            //String decr= cc.decrypt(currS);
            int currK = cc.getKey(currS);
            //System.out.println(currK);
            //System.out.println(decr);
            key[i]=currK;
        }
        return key;
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
        FileResource fr =new FileResource();
        String input = fr.asString();
        int keyLen=4;
        char mostCommon='e';
        int[] intArray=tryKeyLength(input, keyLen, mostCommon);
        VigenereCipher vc=new VigenereCipher(intArray);
        String output=vc.decrypt(input);
        System.out.println(output.substring(0,100));
        
    }
    
    public HashSet<String> readDictionary(FileResource fr){
        HashSet<String> tomatoes=new HashSet<String>();
        for(String s: fr.lines()){
            s=s.toLowerCase();
            tomatoes.add(s);
        }
        return tomatoes;
    }
       public int countWords(String message, HashSet<String> dictionary){
        String[] messageSplit = message.split("\\W+");
        int commonWords = 0;
        for(int i=0; i < messageSplit.length; i++){
            String word = messageSplit[i].toLowerCase();
            if (dictionary.contains(word)){
                commonWords++;
            }
        }

        return commonWords;
    }
    public String breakForLanguage(String encrypted, HashSet<String> dict){
       
        char mostC=mostCommonChar(dict);
        String answer="";
        int keyLen=0;
        int currCount=0; int maxCount=0;
        for(int i=1;i<=100;i++){
            //int i=38;
            int[] keyArray=tryKeyLength(encrypted,i,mostC);
            VigenereCipher vc= new VigenereCipher(keyArray);
            String decrMessage=vc.decrypt(encrypted);
            currCount = countWords(decrMessage, dict);
            if(currCount>maxCount){
                answer=decrMessage;
                maxCount=currCount;
                keyLen= i;
            }
        }
        //System.out.println(encrypted.split("\\W+").length);
        System.out.println("Key Length " +keyLen);
        System.out.println("Valid Words " + maxCount);
        return answer;
    }
    
    public void breakForAllLangs(String encrypted, HashMap<String,HashSet<String>> languages){
            int maxC=0;
            String answer=""; String name= "";
            for(String lang: languages.keySet()){
                String currDecryptedMessage = breakForLanguage(encrypted,languages.get(lang));
                int currCount=countWords(currDecryptedMessage,languages.get(lang));
                if(maxC<currCount){
                    maxC=currCount;
                    answer= currDecryptedMessage;
                    name=lang;
                }
                
            }

                        System.out.println("Decrypted Message \n" +answer);
                        System.out.println("Language Detected \n" +name);
    }
    
    
    
    public void breakVigenereTwo () {

          
        FileResource fres =new FileResource();
        String input = fres.asString();
        /*
        FileResource frdict= new FileResource();       
        HashSet<String> mySet=readDictionary(frdict);        
        String decrMessage= breakForLanguage(input,mySet);
        System.out.println(decrMessage.substring(0,100)); 
        */
        HashMap<String,HashSet<String>> languages = new HashMap<String,HashSet<String>>();
        DirectoryResource dr= new DirectoryResource();
        for(File f : dr.selectedFiles()){
            String name= f.getName();
            FileResource fr = new FileResource("dictionaries/"+name);
            HashSet<String> currDict=readDictionary(fr);
            languages.put(name,currDict);
            System.out.println("We are Working...");
        }
        //HashMap created
        breakForAllLangs(input,languages);
        System.out.println("End Of Line");
    }
}
