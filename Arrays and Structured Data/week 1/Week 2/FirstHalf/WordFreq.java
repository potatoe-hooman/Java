package FirstHalf;
/**
 * Find out how many times each word occurs, and
 * in particular the most frequently occurring word.
 *
 * @author Duke Software Team
 * @version 1.0
 */

import edu.duke.FileResource;

import java.util.ArrayList;

public class WordFreq {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFreq() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource resource = new FileResource();
        for(String s : resource.words()){
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
    
    public void tester(){
        findUnique();
       // System.out.println("# unique words: "+myWords.size());
        int index = findMax();
        int sum = 0;

       for(int i=0; i<myWords.size(); i++){
           System.out.println(myFreqs.get(i) + "\t" + myWords.get(i));
           sum++;
       } 
        System.out.println(sum + "unique");      
            System.out.println("max word/freq: "+myWords.get(index)+" "+myFreqs.get(index));
    }
    public int findMax(){
        int max = myFreqs.get(0);
        int maxIndex = 0;
        for(int k=0; k < myFreqs.size(); k++){
            if (myFreqs.get(k) > max){
                max = myFreqs.get(k);
                maxIndex = k;
            }
        }
        return maxIndex;
    }
}