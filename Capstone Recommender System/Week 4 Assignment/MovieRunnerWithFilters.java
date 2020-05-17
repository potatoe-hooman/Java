
/**
 * Write a description of MovieRunnerWithFilters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class MovieRunnerWithFilters {
    void printAverageRatings(){
        ThirdRatings tRate= new ThirdRatings(
            "data/ratings_short.csv ");
        System.out.println("read data for raters: "
                +tRate.getRaterSize() );
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
    void printAverageRatingsByYear (){
        ThirdRatings tRate= new ThirdRatings(
            "data/ratings_short.csv ");
        System.out.println("read data for raters: "
                +tRate.getRaterSize() );
        int minR =1 ; // initia;izing minimal Rating
        // you can call MovieDataBase.initialise
        MovieDatabase.initialize("ratedmovies_short.csv");        
        System.out.println("Number of movies in DB: " +MovieDatabase.size()); 
        int filterYear = 2000  ;
        YearAfterFilter yaf = new YearAfterFilter(filterYear);
        ArrayList<Rating> mangoList = tRate.getAverageRatingsByFilter(minR,yaf);
        System.out.println("movies: "+mangoList.size());
        Collections.sort(mangoList);
        ArrayList<String> mL = new ArrayList<String>();
        for(Rating r : mangoList){
            if(!mL.contains(r.getItem())){
                System.out.println(r.getValue() + " " 
                    +MovieDatabase.getYear(r.getItem()) +" "
                    +MovieDatabase.getTitle(r.getItem()));    
                mL.add(r.getItem());
            }        
        }
    }
    
    void printAverageRatingsByGenre (){
        String gG="Crime";
        GenreFilter gF= new GenreFilter(gG);
        ThirdRatings tRate= new ThirdRatings(
            "data/ratings_short.csv ");
        System.out.println("read data for raters: "
                +tRate.getRaterSize() );
        int minR =1 ; // initia;izing minimal Rating
        // you can call MovieDataBase.initialise
        MovieDatabase.initialize("ratedmovies_short.csv");        
        System.out.println("Number of movies in DB: " +MovieDatabase.size()); 
        ArrayList<Rating> mangoList = tRate.getAverageRatingsByFilter(minR,gF);
        System.out.println("movies: "+mangoList.size());
        Collections.sort(mangoList);
        ArrayList<String> mL = new ArrayList<String>();
        for(Rating r : mangoList){
            if(!mL.contains(r.getItem())){
                System.out.println(r.getValue() + " " 
                    +MovieDatabase.getTitle(r.getItem())
                    +"\n\t " +MovieDatabase.getGenres(r.getItem()));
                mL.add(r.getItem());
            }        
        }
    }
    void printAverageRatingsByMinutes (){
        int min=110; int max=170;
        MinutesFilter minutesF= new MinutesFilter(min,max);
        ThirdRatings tRate= new ThirdRatings(
            "data/ratings_short.csv ");
        System.out.println("read data for raters: "
                +tRate.getRaterSize() );
        int minR =1 ; // initia;izing minimal Rating
        // you can call MovieDataBase.initialise
        MovieDatabase.initialize("ratedmovies_short.csv");        
        System.out.println("Number of movies in DB: " +MovieDatabase.size()); 
        ArrayList<Rating> mangoList = 
            tRate.getAverageRatingsByFilter(minR,minutesF);
        System.out.println("movies: "+mangoList.size());
        Collections.sort(mangoList);
        ArrayList<String> mL = new ArrayList<String>();
        for(Rating r : mangoList){
            if(!mL.contains(r.getItem())){
                System.out.println(r.getValue() + " " 
                    +MovieDatabase.getTitle(r.getItem())
                    +"\t Time: " +MovieDatabase.getMinutes(r.getItem()));
                mL.add(r.getItem());
            }        
        }
    
    }
    
    void printAverageRatingsByDirectors(){
        String director="Charles Chaplin,Michael Mann,Spike Jonze";
        DirectorsFilter dF= new DirectorsFilter (director);
        ThirdRatings tRate= new ThirdRatings(
            "data/ratings_short.csv ");
        System.out.println("read data for raters: "
                +tRate.getRaterSize() );
        int minR =1 ; // initia;izing minimal Rating
        // you can call MovieDataBase.initialise
        MovieDatabase.initialize("ratedmovies_short.csv");        
        System.out.println("Number of movies in DB: " +MovieDatabase.size()); 
        ArrayList<Rating> mangoList = tRate.getAverageRatingsByFilter(minR,dF);
        System.out.println("movies: "+mangoList.size());
        Collections.sort(mangoList);
        ArrayList<String> mL = new ArrayList<String>();
        for(Rating r : mangoList){
            if(!mL.contains(r.getItem())){
                System.out.println(r.getValue() + " " 
                    +MovieDatabase.getTitle(r.getItem())
                    +"\n\t" +MovieDatabase.getDirector(r.getItem()));
                mL.add(r.getItem());
            }        
        }
    }
    void printAverageRatingsByYearAfterAndGenre (){
        AllFilters all=new AllFilters();
        int year = 1980;
        String myGen ="Romance";
        all.addFilter(new GenreFilter(myGen));
        all.addFilter(new YearAfterFilter(year));
        
        ThirdRatings tRate= new ThirdRatings(
            "data/ratings_short.csv ");
        System.out.println("read data for raters: "
                +tRate.getRaterSize() );
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
    void printAverageRatingsByDirectorsAndMinutes (){
        AllFilters all=new AllFilters();
        // to create an array of filters
        int min = 30; int max =170; 
        // initialising paramneters
        String directors ="Spike Jonze,Michael Mann,Charles Chaplin,Francis Ford Coppola";
        all.addFilter(new MinutesFilter(min,max));
        //adding filters to list
        all.addFilter(new DirectorsFilter(directors));
        // creating third rating object
        ThirdRatings tRate= new ThirdRatings(
            "data/ratings_short.csv ");
        System.out.println("read data for raters: "
                +tRate.getRaterSize() );
        int minR =1 ; // initia;izing minimal Rating
        // you can call MovieDataBase.initialise
        MovieDatabase.initialize("ratedmovies_short.csv");        
                        
        System.out.println("Number of movies in DB: " +MovieDatabase.size()); 
        ArrayList<Rating> mangoList = tRate.getAverageRatingsByFilter(minR,all);
        //list of ratings
        System.out.println("movies: "+mangoList.size());
        Collections.sort(mangoList);
        // sorting for readablity
        ArrayList<String> mL = new ArrayList<String>();
        // list of movies id as string
        for(Rating r : mangoList){
            //for each movie id
            if(!mL.contains(r.getItem())){
                // if it is in there print details
                System.out.println(r.getValue() + " " 
                    +MovieDatabase.getTitle(r.getItem()) + " \t Time: " 
                    +MovieDatabase.getMinutes(r.getItem()) 
                    +"\n\t" +MovieDatabase.getDirector(r.getItem()));
                mL.add(r.getItem());
                // if that item has been found add it tot the list 
                //so that it coundn't be found again as we dont want repeated answers
            }        
        }
    }
    
    
}
