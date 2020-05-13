
/**
 * Write a description of ThirdRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import org.apache.commons.csv.*;
import edu.duke.*;

public class ThirdRatings {
    private ArrayList<Rater> myRaters;
    
    public ThirdRatings() {
        // default constructor
        this( "data/ratings_short.csv");
    }
    public ThirdRatings(String ratingfile){
        // create a FirstRatings object and read files thru it
        FirstRatings fRate = new FirstRatings();
        myRaters = fRate.loadRaters(ratingfile);        
    }
    public int getRaterSize(){
        return myRaters.size();
    }
    public double getAverageByID(String movieID, int minimal){
        double count=0.0; double sum=0.0; // initialising variable
                for(Rater r : myRaters){
            // for each rater
                for(Rating rt : r.getRatings()){
                    ///for eachrating that rater has made
                    if(rt.getItem().equals(movieID)){
                        // if he has rated that movie
                      count=count+1.0;  // increase count
                      sum=sum+rt.getValue(); // add ratings
                      //System.out.println(rt.getValue());
                    }
                
            }
            
        }
        if(count>=minimal){ 
            //if ratings recieved to that movie is more than minimal
            
            return sum/count;  
            // return average
        }
        return 0.0; //when we have ratings less than minimal
    }
    
    public ArrayList<Rating> getAverageRatings_Week2(int minRaters){
      ArrayList<Rating> Average = new ArrayList<Rating>();  // initialising an arraylist
      for(Rater r : myRaters){ // for each rater
            for(Rating rt: r.getRatings()){ // for each rating
                String ID = rt.getItem(); //get movie id
                //System.out.println(ID);
                double currRating=getAverageByID(ID,minRaters); // finds its aveage rating
                Rating avgRating= new Rating(ID,currRating); // create a rating object/instance
                if(currRating!=0){ // if current rating is not 0.0 ( ie. if it had more or equal raters
                    Average.add(avgRating); // add it to the average list
                }
            }
      }
      return Average; // obtain the list
      // return the list of all ratings available rating object is ( Movie Id, Rating given)
    }
    
    public ArrayList<Rating> getAverageRatings(int minRaters){
      ArrayList<String> mList = new ArrayList<String>();
      // initialising an arraylist of movie id
      mList=MovieDatabase.filterBy(new TrueFilter());
      // string of movie ids
      ArrayList<Rating> Average = new ArrayList<Rating>();
      for(String currID : mList){ // for each id
          Double rated= getAverageByID(currID,minRaters);
          // find its avg rating
          if(rated!=0.0){ // if rated by that many
          Rating currRating= new Rating(currID,rated);
          // create a rating object
          Average.add(currRating);
          // add this to list
        }
        }
      return Average; // obtain the list
      // return the list of all ratings available rating object is ( Movie Id, Rating given)
    }
    public ArrayList<Rating> getAverageRatingsByFilter (int minR, Filter filterCriteria){
        ArrayList<Rating> listR = new ArrayList<Rating>();
        // list of Ratings
        ArrayList<String> mList = new ArrayList<String>();
        // list of movie ids
        mList=MovieDatabase.filterBy(filterCriteria);
        // filtered list by a criteria given
        for(String m: mList){
            // for ead movie id
             Double rated= getAverageByID(m,minR);
              // find its avg rating
              if(rated!=0.0){ 
                  // if rated by that many raters
              Rating currRating= new Rating(m,rated);
              // create a rating object
              listR.add(currRating);
              // add this to list
           }
            }
        return listR;
        }
 
    
    }
