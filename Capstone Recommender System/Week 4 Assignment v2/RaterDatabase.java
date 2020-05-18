
/**
 * Write a description of RaterDatabase here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;

public class RaterDatabase {
    private static HashMap<String,Rater> ourRaters;
     // ourRaters maps a rater ID String to a Rater object 
	private static void initialize() {
	    // this method is only called from addRatings 
		if (ourRaters == null) {
			ourRaters = new HashMap<String,Rater>();
		}
	}

    public static void initialize(String filename) {
 		if (ourRaters == null) {
 			ourRaters= new HashMap<String,Rater>();
 			addRatings("data/" + filename);
 		}
 	}	
 	
    public static void addRatings(String filename) {
        initialize(); 
        //add rater ratings to the database from a file
        FileResource fr = new FileResource(filename);
        CSVParser csvp = fr.getCSVParser();
        for(CSVRecord rec : csvp) {
                String id = rec.get("rater_id");
                String item = rec.get("movie_id");
                String rating = rec.get("rating");
                addRaterRating(id,item,Double.parseDouble(rating));
        } 
    }
    
    public static void addRaterRating(String raterID, String movieID, double rating) {
        initialize(); 
        //This function can be used to add one rater and 
        //their movie rating to the database
        Rater rater =  null;
                if (ourRaters.containsKey(raterID)) {
                    // if the rater is already there 
                    rater = ourRaters.get(raterID); 
                } 
                else { 
                    // if the rater is not there
                    rater = new EfficientRater(raterID);
                    ourRaters.put(raterID,rater);
                 }
                 rater.addRating(movieID,rating);
    } 
	         
    public static Rater getRater(String id) {
    	initialize();
    	// returns Rater that has this id
    	return ourRaters.get(id);
    }
    
    public static ArrayList<Rater> getRaters() {
    	initialize();
    	ArrayList<Rater> list = new ArrayList<Rater>(ourRaters.values());
    	// ArrayList of Raters from the database. 
    	return list;
    }
 
    public static int size() {
	    return ourRaters.size();
	    // number of raters
    }
    
    
        
}
