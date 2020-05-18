
/**
 * Write a description of FourthRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
    import java.util.*;
    import org.apache.commons.csv.*;
    import edu.duke.*;

public class FourthRatings {
    
     public FourthRatings () {
        // default constructor
        this("ratings.csv");
    }
    
    public FourthRatings (String ratingsfile) {
        RaterDatabase.initialize(ratingsfile);
    }
    
    public double getAverageByID(String movieID, int minimal){
        double count=0.0; double sum=0.0; // initialising variable
        ArrayList<Rater> rList = RaterDatabase.getRaters();
                for(Rater r : rList){
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
        ArrayList<String> mList = MovieDatabase.filterBy(filterCriteria);
        // list of movie ids        
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
    
    private Double dotProduct(Rater me, Rater r){
        // dot product in matlab, sum(me.*r);
        
        double sum=0;
        for(String id : me.getItemsRated()){
            // for each movie
            if(r.hasRating(id)){
                // if both of them have rated                
                sum=sum+(me.getRating(id)-5)*(r.getRating(id)-5);
                // scaling from 1-10 to -5 to 5
                // find the sum of their product
             }
        }
        return sum;        
    }    
  
    private ArrayList<Rating> getSimilarities(String xRaterID){
        // this method computes a similarity rating for each rater
        ArrayList<Rating> list = new ArrayList<Rating>();
        Rater me = RaterDatabase.getRater(xRaterID);
        for(Rater r : RaterDatabase.getRaters()){            
                double currDot = dotProduct(me,r);
            if(!r.getID().equals(xRaterID) && currDot>0){ 
                
                Rating dotRate= new Rating(r.getID(),currDot);
                list.add(dotRate);
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list.get(1).getValue()+" " +list.get(2).getValue() +" " +list.get(3).getValue()
            +" " +list.get(4).getValue() +" " +list.get(5).getValue());
        return list;
    }
    
    public ArrayList<Rating> getRecommendations(String id, int numRaters){
        //calculating weighted avg
        ArrayList<Rating> list = getSimilarities(id);    
        ArrayList<Rating> ret = new ArrayList<Rating>();
        for( String mID : MovieDatabase.filterBy(new TrueFilter())){
            int sum=0;
            for(int i=0; i<numRaters;i++){
                Rating r= list.get(i);                
                sum=sum+ (int)r.getValue();
                
            }
              ret.add(new Rating(mID,sum));          
        }
        Collections.sort(ret,Collections.reverseOrder());
        return ret;
    }
   
    private ArrayList<Rating> callMe(String id, int nSR, int mR, Filter fr){
        ArrayList<Rating> similarRaters = getSimilarities(id); //rater id with a score
        ArrayList<Rating> limitedSimilarRating = new ArrayList<>(); //to be filled and used
        ArrayList<Rating> ret= new ArrayList<Rating>(); // to be returned
        
        HashMap<String,Double> myMap = new HashMap();
        // hashmap of raterID and rating
        int mapSize = getSimilarities(id).size(); // should be same as the list of raters
        int minIndex = Math.min(mapSize, nSR);

        for(Rating rt : getSimilarities(id).subList(0,minIndex)){
            if(rt.getValue()>0){
                // only positive values
                myMap.put(rt.getItem(), rt.getValue());
            }
        }

        for(String m : MovieDatabase.filterBy(fr)){
            int count =0; // times rated in top nSR
            double total =0; //sum

            for(Rater curRater:RaterDatabase.getRaters()){
                double rating = -1; 
                // if not found
                // lets check (if found)
                String raterID=curRater.getID();
                if(myMap.containsKey(raterID) && curRater.hasRating(m)){
                    // if myMap had that raterID and this rater has rated that movie
                    rating = curRater.getRating(m) * myMap.get(raterID);
                    // rating for that rater, normalised
                }

                if(rating ==-1){ 
                    //if not found, do nothing
                }

                else{
                    count++; // found, inc count
                    total = total + rating; // inc sum
                }
            }

            if(count< mR || total==0){ 
                // if sum is not pos of less than rated, do noth a thing
            }
            
            else{
                ret.add(new Rating(m, total/count));
                // add movie id and weighted avg
            }

        }
        Collections.sort(ret, Collections.reverseOrder());      
        return ret;
    }
    
    public ArrayList<Rating> getSimilarRatings(String id, int nSR, int mR){       
        TrueFilter allpass = new TrueFilter();
        ArrayList<Rating> ret= callMe( id,  nSR,  mR,  allpass);
        Collections.sort(ret,Collections.reverseOrder());
        return ret;
    }
    
     public ArrayList<Rating> getSimilarRatingsByFilter(String id, int nSR, int mR, Filter fr){     
        
        ArrayList<Rating> ret= callMe(id, nSR, mR, fr);
        Collections.sort(ret,Collections.reverseOrder());
        return ret;
    }

}
