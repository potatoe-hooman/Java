
/**
 * Write a description of MovieRunnerAverage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class MovieRunnerAverage {
    void printAverageRatings(){
        SecondRatings sRate= new SecondRatings(
            "data/ratedmovies_short.csv",
            "data/ratings_short.csv ");
        System.out.println(sRate.getRaterSize() +" raters"
                +sRate.getMovieSize()+ " movies.");
        int minR =3 ; // initia;izing minimal Rating
        ArrayList<Rating> mangoList = sRate.getAverageRatings(minR);
        //System.out.println(mangoList.size());
        Collections.sort(mangoList);
        ArrayList<String> mL = new ArrayList<String>();
        for(Rating r : mangoList){
            if(!mL.contains(r.getItem())){
                System.out.println(r.getValue() + " " 
                    +sRate.getTitle(r.getItem()));    
                mL.add(r.getItem());
            }        
        }
    }
    void getAverageRatingOneMovie(){
        SecondRatings sR = new SecondRatings();
        String title = "The Godfather";
        String currID = sR.getID(title);
        System.out.println("Current Movie ID detected as per name: "+currID);
        Double currR= sR.getAverageByID(currID, 0);  // had to make this public
        System.out.println(title +"  " +currR);
    }
    
    }
