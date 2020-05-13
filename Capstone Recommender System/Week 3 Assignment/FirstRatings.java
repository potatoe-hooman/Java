
/**
 * Write a description of FirstRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;
public class FirstRatings {
    public ArrayList<Movie> loadMovies(String filename){
        ArrayList<Movie> listOfMovies= new ArrayList<Movie>();
        FileResource fr= new FileResource(filename);
        CSVParser parser = fr.getCSVParser();
        for(CSVRecord row : parser){
                // get each element
             String id = row.get("id");
             String title = row.get("title") ;
             String year=row.get("year");
             String genres=row.get("genre");
             String director=row.get("director");
             String country=row.get("country");
             String poster=row.get("poster");
             int minutes=Integer.parseInt(row.get("minutes"));
                // pass each element to create a new MOvie datatype
            Movie currM=new Movie(id,title,year,genres,director,country,poster,minutes);
            
            listOfMovies.add(currM);
        }
        return listOfMovies;
    }
    
    public ArrayList<Rater> loadRaters (String filename){
        ArrayList<Rater> listOfRater= new ArrayList<Rater>();
        FileResource fr= new FileResource(filename);
        CSVParser parser = fr.getCSVParser();
        ArrayList<String> idList= new ArrayList<String>();
        
        ArrayList<String> idList2= new ArrayList<String>();
        for(CSVRecord row : parser){
                // get each element
                String myID = row.get("rater_id");    
                
              if(!idList.contains(myID)){
                       // if the rater is not there
                  Rater raterP = new EfficientRater(myID);    // create a fresh rater
                  //EfficientRater raterP = new EfficientRater(myID);
                  idList.add(myID); // add it to  check list
                  
                  raterP.addRating(row.get("movie_id"), Double.parseDouble(row.get("rating")));
                  listOfRater.add(raterP);
              }
              else{
                  // if the rater is already reistered
                  for(Rater r : listOfRater){
                      if(r.getID().equals(myID)){ // rater whose id matches the ID I'm looking for
                          // pick that rater
                          Rater raterP = r;
                          
                          raterP.addRating(row.get("movie_id"), Double.parseDouble(row.get("rating")));
                        }                    
                                  
                }
                }
                         
            }
           
            ArrayList<Rater> rom = new ArrayList<Rater>();
        for(Rater r: listOfRater){
            if(!idList2.contains(r.getID())){   
                rom.add(r);
                idList2.add(r.getID());
            }
            
        }    
        
         return rom;
              
        }
        
        
    
        void testLoadMovies(){
        //String currFile="ratedmovies_short.csv";
        String currFile="ratedmoviesfull.csv";
        ArrayList<Movie> mv= loadMovies("data/"+currFile);
        int genereCount=0;
        int movieWithLength=0;
        HashMap<String,Integer> dCount = new HashMap<String,Integer>();
        for(Movie m : mv){
            //System.out.println(m.toString());
            //to find no. of movies with genere Comedy
            if(m.getGenres().contains("Comedy")) genereCount=genereCount+1;   
            // to find no. of movies with length > 150 minutes
            if(m.getMinutes()>150) movieWithLength=movieWithLength+1;
            // to find the highest number of movies directed by any director and who they are
            String allD= m.getDirector();
            String[] arr = allD.split(",");
            //creating a hashmap of directors with their count
                for(String d : arr){
                    if(dCount.containsKey(d)){
                        int count = dCount.get(d);
                        dCount.put(d,count+1);
                    }
                    else{
                    dCount.put(d,1);
                   }
                }
                
            }
            int max=0;
            for(Integer in : dCount.values()){
                    if(in>max){
                        max=in;
                    }
                }
                
            for(String s: dCount.keySet()){
                    if(dCount.get(s)==max){
                        System.out.println("Director" +s +" with " +max +" films");
                    }
                }
        System.out.println("size "+mv.size());         
        System.out.println("Genre: "+genereCount); 
        System.out.println("minutes "+movieWithLength); 
    }
    
    void testLoadRaters(){
        // loading the file and parsing it
        String address= "ratings.csv";
        String location = "data/"+address;
        ArrayList<Rater> raterList = loadRaters(location);
        HashMap<String,Integer> idCount = new HashMap<String,Integer>(); 
        //1.create a a hasmap of IDs and Number of Rating
        
         for(Rater r : raterList){
            // thsi hashmap creater may get some bug as it was made in Week 1, some changes in week 2
            if(idCount.containsKey(r.getID())){
                int c = idCount.get(r.getID());
                idCount.put(r.getID(),c+1);
            }
            else{
                idCount.put(r.getID(),1);
            }            
            
        }
        int highestC=0;//highest number of rating 
        //3. we will find how many raters are thee with this number and who they are
        String partiM="1798709";// how many timees is this rated
        int cc=0; // keeps count
        ArrayList<String> mlist= new ArrayList<String>();
        for(String s : idCount.keySet()){
            // rater id and count of ratings
            System.out.println("Rater Id " + s + " "+" Ratings made " +idCount.get(s));
                if(highestC<idCount.get(s)){
                    highestC=idCount.get(s);
                }
            // for each id print movie id and rating
            for(Rater r : raterList){
                if(r.getID().equals(s)){
                ArrayList<Rating> rrlist= r.getRatings();
                for(Rating rr: rrlist){
                    System.out.println("\t Movie Id " +rr.getItem() +" and Rating Given " +rr.getValue());
                    if(rr.getItem().equals(partiM)){cc=cc+1;}
                    
                    if(!mlist.contains(rr.getItem())) mlist.add(rr.getItem());
                }
              }
              
            }
        }
        int diffM=mlist.size();
        System.out.println("No of Raters" +idCount.size());
        //2. for particular
        String parti="193";
        int count = idCount.get(parti);
        System.out.println("Counts for " + parti + " is " + count);
        
        System.out.println("Highest no.of ratings from a Rater" +highestC);
        for(String s : idCount.keySet()){
            if(idCount.get(s)==highestC){
                System.out.println("Rater id with highest "+s);
            }
        }
                        System.out.println("Reviews for a paticular movie "+cc );
                        System.out.println("Total movies" +diffM);
        }      
    
    
}
