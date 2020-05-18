
/**
 * Write a description of MovieRunnerSimilarRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class MovieRunnerSimilarRatings {
    void printAverageRatings(){
        FourthRatings tRate= new FourthRatings();
        RaterDatabase.initialize("ratings_short.csv");
        System.out.println("read data for raters: "
                +RaterDatabase.size() );
        int minR =1 ; // initia;izing minimal Rating
        // you can call MovieDataBase.initialise
        MovieDatabase.initialize("ratedmovies_short.csv");        
        System.out.println("Number of movies in DB: " +MovieDatabase.size()); 
        ArrayList<Rating> mangoList = tRate.getAverageRatings(minR);
        System.out.println("read data for movies: "+mangoList.size());
        Collections.sort(mangoList);
        ArrayList<String> mL = new ArrayList<String>();
        for(Rating r : mangoList){
            if(!mL.contains(r.getItem())){
                System.out.println(r.getValue() + " " 
                    +MovieDatabase.getTitle(r.getItem()));    
                mL.add(r.getItem());
            }        
        }
    }
    
    void printSimilarRatings (){ 
        FourthRatings x4Rate= new FourthRatings();
        
        RaterDatabase.initialize("ratings.csv");
        System.out.println("read data for raters: " +RaterDatabase.size());
        
        MovieDatabase.initialize("ratedmoviesfull.csv");        
        System.out.println("Number of movies in DB: " +MovieDatabase.size()); 
        
        int numSimilarRaters=20; int minimalRaters=5 ;  String raterID ="65";
        
        ArrayList<Rating> reco = x4Rate.getSimilarRatings(raterID, numSimilarRaters, minimalRaters);
        System.out.println("Total Entries: " +reco.size());
        for(int i =0; i<reco.size();i++){
            System.out.println(MovieDatabase.getTitle((reco.get(i).getItem())) + " " +reco.get(i).getValue());
        }
    }
   
    void printAverageRatingsByYearAfterAndGenre (){
        AllFilters all=new AllFilters();
        int year = 1980;
        String myGen ="Romance";
        all.addFilter(new GenreFilter(myGen));
        all.addFilter(new YearAfterFilter(year));
        
        FourthRatings tRate= new FourthRatings();
        RaterDatabase.initialize("ratings_short.csv");
        System.out.println("read data for raters: "
                +RaterDatabase.size());
        int minR =1 ; // initia;izing minimal Rating
        // you can call MovieDataBase.initialise
        MovieDatabase.initialize("ratedmovies_short.csv");        
                        
        System.out.println("Number of movies in DB: " +MovieDatabase.size()); 
        ArrayList<Rating> mangoList = tRate.getAverageRatingsByFilter(minR,all);
        System.out.println("movies: "+mangoList.size());
        Collections.sort(mangoList);
        ArrayList<String> mL = new ArrayList<String>();
        for(Rating r : mangoList){
            if(!mL.contains(r.getItem())){
                System.out.println(r.getValue() + " " 
                    +MovieDatabase.getTitle(r.getItem())
                    +"\n\t" +MovieDatabase.getGenres(r.getItem()));
                mL.add(r.getItem());
            }        
        }
    }
    
    void helper(){
                
        RaterDatabase.initialize("ratings.csv");
        System.out.println("read data for raters: " +RaterDatabase.size());
        
        MovieDatabase.initialize("ratedmoviesfull.csv");        
        System.out.println("Number of movies in DB: " +MovieDatabase.size()); 
        
    
    }
    
    void printSimilarRatingsByGenre (){
        FourthRatings x4Rate= new FourthRatings();       
        helper();
        int numSimilarRaters=20; int minimalRaters=5 ;  String raterID ="65";
        Filter f = new GenreFilter("Action");
        ArrayList<Rating> reco = x4Rate.getSimilarRatingsByFilter(raterID, numSimilarRaters, minimalRaters,f);
        Collections.sort(reco,Collections.reverseOrder());
        for(int i =0; i<reco.size();i++){
            System.out.println(MovieDatabase.getTitle((reco.get(i).getItem())) 
                    + " " +reco.get(i).getValue() +"\n\t" +MovieDatabase.getGenres((reco.get(i).getItem())));
        }
    }
    
    void printSimilarRatingsByDirector (){
        FourthRatings x4Rate= new FourthRatings();       
        helper();
        int numSimilarRaters=10; int minimalRaters=3 ;  String raterID ="1034";
        Filter f = new DirectorsFilter("Clint Eastwood,Sydney Pollack,David Cronenberg,Oliver Stone");
        ArrayList<Rating> reco = x4Rate.getSimilarRatingsByFilter(raterID, numSimilarRaters, minimalRaters,f);
        for(int i =0; i<reco.size();i++){
            System.out.println(MovieDatabase.getTitle((reco.get(i).getItem())) 
                    + " " +reco.get(i).getValue() +"\n\t" +MovieDatabase.getDirector((reco.get(i).getItem())));
        }
    }
    
    void printSimilarRatingsByGenreAndMinutes(){
        FourthRatings x4Rate= new FourthRatings();       
        helper();
        int numSimilarRaters=10; int minimalRaters=5 ;  String raterID ="65";
        Filter f1 = new GenreFilter("Adventure");
        Filter f2 = new MinutesFilter(100,200);
        AllFilters f = new AllFilters();
        f.addFilter(f1);
        f.addFilter(f2);
        ArrayList<Rating> reco = x4Rate.getSimilarRatingsByFilter(raterID, numSimilarRaters, minimalRaters,f);
        for(int i =0; i<reco.size();i++){
            System.out.println(MovieDatabase.getTitle((reco.get(i).getItem())) 
                    + " " +reco.get(i).getValue() +"\n\t" +MovieDatabase.getGenres((reco.get(i).getItem()))
                    +"\t Minutes: " +MovieDatabase.getMinutes((reco.get(i).getItem())));
        }
    }
    void printSimilarRatingsByYearAfterAndMinutes (){
        FourthRatings x4Rate= new FourthRatings();       
        helper();
        int numSimilarRaters=10; int minimalRaters=5 ;  String raterID ="65";
        Filter f1 = new YearAfterFilter(2000);
        Filter f2 = new MinutesFilter(80,100);
        AllFilters f = new AllFilters();
        f.addFilter(f1);
        f.addFilter(f2);
        ArrayList<Rating> reco = x4Rate.getSimilarRatingsByFilter(raterID, numSimilarRaters, minimalRaters,f);
        for(int i =0; i<reco.size();i++){
            System.out.println(MovieDatabase.getTitle((reco.get(i).getItem())) 
                    + " " +reco.get(i).getValue() +"\n\t" +MovieDatabase.getDirector((reco.get(i).getItem())));
        }
    }
}
