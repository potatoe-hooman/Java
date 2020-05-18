import java.util.*;
import org.apache.commons.csv.*;
import edu.duke.FileResource;

public class MovieDatabase {
    private static HashMap<String, Movie> ourMovies;
        //ourMovies that maps a movie ID String to a Movie
        //object with all the information about that movie
    
    public static void initialize(String moviefile) {
        
        // moviefile is the filename, to inintialize database
        if (ourMovies == null) {
            ourMovies = new HashMap<String,Movie>();
            loadMovies("data/" + moviefile);
        }
    }

    private static void initialize() {
        //this is for a safety check
        if (ourMovies == null) {
            ourMovies = new HashMap<String,Movie>();
            loadMovies("data/ratedmoviesfull.csv");
        }
    }   
    
    private static void loadMovies(String filename){
        // builds the hashmap
        FirstRatings fr = new FirstRatings();
        ArrayList<Movie> list = fr.loadMovies(filename);
        for (Movie m : list) {
            ourMovies.put(m.getID(), m);
        }
    }

    public static boolean containsID(String id) {
        initialize();
        //returns true if the id is a movie in the database
        return ourMovies.containsKey(id);
    }

    public static int getYear(String id) {
        initialize(); // if record doesn't exist use safety
        return ourMovies.get(id).getYear();
    }

    public static String getGenres(String id) {
        initialize();
        // takes movieID as parameter
        return ourMovies.get(id).getGenres();
    }

    public static String getTitle(String id) {
        initialize();
        return ourMovies.get(id).getTitle();
    }

    public static Movie getMovie(String id) {
        initialize();
        return ourMovies.get(id);
    }

    public static String getPoster(String id) {
        initialize();
        return ourMovies.get(id).getPoster();
    }

    public static int getMinutes(String id) {
        initialize();
        return ourMovies.get(id).getMinutes();
    }

    public static String getCountry(String id) {
        initialize();
        return ourMovies.get(id).getCountry();
    }

    public static String getDirector(String id) {
        initialize();
        return ourMovies.get(id).getDirector();
    }

    public static int size() {
        return ourMovies.size(); //number of movies 
    }

    public static ArrayList<String> filterBy(Filter f) {
        initialize();
        
        ArrayList<String> list = new ArrayList<String>();
        for(String id : ourMovies.keySet()) {
            // id is for that Movie ID
            if (f.satisfies(id)) {
                // f is the name of filter that we tend to use
                // ex: allTrue.satiesfies(id)
                list.add(id);
            }
        }
        
        return list; // list of movie IDs
    }

}
