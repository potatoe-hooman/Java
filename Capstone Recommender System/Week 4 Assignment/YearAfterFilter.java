
public class YearAfterFilter implements Filter {
	private int myYear;
	//movies that were created on that year or
	//created later than that year
	public YearAfterFilter(int year) {
		myYear = year;
		// must be inintialised before calling
	}
	
	@Override
	public boolean satisfies(String id) {
		return MovieDatabase.getYear(id) >= myYear;
	}

}
