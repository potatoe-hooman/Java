
/**
 * Write a description of MarkovOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class MarkovOne {
    private String myText;
    private Random myRandom;
    
    public MarkovOne() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }
    
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-1);
        String key = myText.substring(index, index+1);
        sb.append(key);
        for(int k=0; k < numChars-1; k++){
            ArrayList<String> follows= getFollows(key);
            if(follows.size() == 0){
				break;
			}
             index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
			sb.append(next);
			key = key.substring(1) + next;
        }
        
        return sb.toString();
    }
    
    public ArrayList<String> getFollows(String key){
        ArrayList<String> entries = new ArrayList<String>();

        int currIndex=0;
        int prev=0;        
        
        while(currIndex>-1){
                currIndex=myText.indexOf(key, prev);
                if(currIndex==myText.length()-key.length()){
                    break;
                }
                if(currIndex==-1){
                    break;
                }
                //System.out.println(currIndex);
                int which=currIndex+key.length();
                entries.add(myText.substring(which,which+1));
                prev=currIndex+1;
            }
               return entries;
    }
    
}
