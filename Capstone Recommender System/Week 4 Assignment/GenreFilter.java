
/**
 * Write a description of GenreFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GenreFilter implements Filter {
    private String myGenre;
	//movies that were created on that genre o
	public GenreFilter(String genre) {
		myGenre = genre;
		// must be inintialised before calling
	}
	
	@Override
	public boolean satisfies(String id) {
		return MovieDatabase.getGenres(id).contains(myGenre);
	}

}
