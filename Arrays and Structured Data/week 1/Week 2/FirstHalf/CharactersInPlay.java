package FirstHalf;

/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class CharactersInPlay {
    private ArrayList<String> storeName;
    private ArrayList<Integer> storeCount;
    
    public CharactersInPlay(){
        storeName= new ArrayList<String>();
        storeCount=new ArrayList<Integer>();        
    }
    
    void update(String person){
        person = person.toLowerCase();
        int index = storeName.indexOf(person);
        if (index == -1) {
            storeName.add(person);
            storeCount.add(1);
        } 
        else {
            int freq = storeCount.get(index);
            storeCount.set(index, freq + 1);
        }
     }
    
    void findAllCharacters(){
        storeCount.clear();
        storeName.clear();
        FileResource fr =new FileResource();
        for(String s: fr.lines()){
            int periodInLine = s.indexOf(".");
            if (periodInLine != -1) {
                //extract the possible name of the speaking part
                String possibleName = s.substring(0, periodInLine);
                //and call update() to count it as an occurrence for this person
                update(possibleName);
            }
        }
    }
    
      public int findMax() {
        int maxElement = storeCount.get(0);
        int maxIndex = 0;
        for (int k = 0; k < storeCount.size(); k++) {
            if (storeCount.get(k) > maxElement) {
                maxElement = storeCount.get(k);
                maxIndex = k;
            }
        }

        return maxIndex;
    }
    
    void tester(){
        findAllCharacters();
        for(int i=0; i<storeName.size();i++){
            String name= storeName.get(i);
            int freq= storeCount.get(i);
            System.out.println(name + "\t" +freq );
                       

        }
                System.out.println("MAxOccured " +storeCount.get(findMax()) 
                        +" observed by" +storeName.get(findMax()));
        System.out.println("Total Unique Characeters " 
                        +storeName.size());
        charactersWithNumParts(50,102);
    }
    
    void charactersWithNumParts(int a, int b){
        System.out.println(" Characters With name in Range" 
                            +a +" and " +b);
        for(int k=0; k<storeCount.size(); k++){
            
            if(storeCount.get(k)<=b && storeCount.get(k)>=a){
                System.out.println(storeName.get(k) 
                +" " +storeCount.get(k));
            }
            
        }
    }
    
}
