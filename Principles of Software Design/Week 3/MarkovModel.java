
/**
 * Write a description of MarkovFour here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class MarkovModel  {
    private String myText;
    private Random myRandom;
    private int mmNum;
    
    public MarkovModel (int n) {
        myRandom = new Random();
        mmNum=n;
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
        int index = myRandom.nextInt(myText.length()-mmNum);
        String key = myText.substring(index, index+mmNum);
        sb.append(key);
        for(int k=0; k < numChars-mmNum; k++){
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

