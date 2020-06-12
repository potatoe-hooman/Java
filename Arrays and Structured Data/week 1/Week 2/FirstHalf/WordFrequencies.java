package FirstHalf;


/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class WordFrequencies {
        private ArrayList<String> myWords;
        private ArrayList<Integer> myFreqs; 
        
      public WordFrequencies(){
        myWords=new ArrayList<String>();
        myFreqs =new ArrayList<Integer>();
        }
        
      public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource fr= new FileResource();
         for(String s : fr.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if (index == -1){
                myWords.add(s);
                myFreqs.add(1);
            }
            else {
                int freq = myFreqs.get(index);
                myFreqs.set(index,freq+1);
            }
        }
        }
      int findIndexOfMax (){
        int maxPos=0;
        int maxValue=0;
        for(String item:myWords){
            int idx= myWords.indexOf(item);
            int magic=myFreqs.get(idx);
            if(magic>maxValue){
                maxValue=magic;
                maxPos=idx;
            }
            
            //System.out.println("Words is :" +item +" and has a count of : " +magic);
        }
        System.out.println(maxValue +" "+maxPos);
        return maxPos;
        }
      void tester(){
        findUnique();
        int size=myFreqs.size();
        System.out.println("Unique words : " +size);
        /*for(String item:myWords){
            int idx= myWords.indexOf(item);
            int magic=myFreqs.get(idx);
            System.out.println("Words is :" +item +" and has a count of : " +magic);
        }*/
        int maxPos=findIndexOfMax();
        System.out.println("Max Position observed at: " 
            +" with counts " +myFreqs.get(maxPos) +"for " +myWords.get(maxPos));
        
       }
    
}
