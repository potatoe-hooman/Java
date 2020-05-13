
/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import org.apache.commons.csv.*;
import edu.duke.*;
public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    public SecondRatings() {
        // default constructor
        this("data/ratedmovies_short.csv", "data/ratings_short.csv");
    }
    public SecondRatings(String moviefile,String ratingfile){
        // create a FirstRatings object and read files thru it
        FirstRatings fRate = new FirstRatings();
        myMovies= fRate.loadMovies(moviefile);
        myRaters = fRate.loadRaters(ratingfile);        
    }
    public int getMovieSize(){
        return myMovies.size();
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
    public ArrayList<Rating> getAverageRatings(int minRaters){
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
    public String getTitle(String id){
        // id is movie id
        for(Movie m : myMovies){ //  for each movie 
            if(m.getID().equals(id)){
                // if movie id is found
                return m.getTitle();
                //return its title
            }
        }
        return "Movie Id not found";
        // if not found show an error
    }
    
    public String getID(String title){
        // title is movie title
        for(Movie m : myMovies){ //  for each movie 
            if(m.getTitle().equals(title)){
                // if movie title is found
                return m.getID(); // return its ID
            }
        }
        return "Movie Title not found";
        // if not found show an error
    }
}



