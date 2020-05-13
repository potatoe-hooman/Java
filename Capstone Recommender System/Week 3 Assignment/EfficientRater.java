
/**
 * Write a description of EfficientRater here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class EfficientRater implements Rater{
    private String myID;
    private HashMap<String,Rating> myRatings;
    // key of this map is movieID, ie in String
    public EfficientRater(String id) {
        myID = id;
        myRatings = new HashMap<String,Rating>();
    }

    public void addRating(String item, double rating) {
        myRatings.put(item,new Rating(item,rating));
        
    } 
    public boolean hasRating(String item) {
        
            if (myRatings.containsKey(item)){
                return true;
            }
                
        return false;
    }
    
    public String getID() {
        return myID;
    }
    // if I try to obtaing Rating List simmilarly
    public ArrayList<Rating> getRatings() {
        ArrayList<Rating> allRatings= new ArrayList<Rating>();
        for( String id: myRatings.keySet()){
            allRatings.add(myRatings.get(id));
        }
        return allRatings;
    }
    
    public double getRating(String item) {
        
            if (myRatings.containsKey(item)){
                myRatings.get(item).getValue();
            }
               
        // this fuction takes in movie id and return ratings for that movie
        return -1;
    }
    

    public int numRatings() {
        return myRatings.size();
    }

    public ArrayList<String> getItemsRated() {
        ArrayList<String> list = new ArrayList<String>();
        for(int k=0; k < myRatings.size(); k++){
            list.add(myRatings.get(k).getItem());
        }
        
        return list;
    }
}


