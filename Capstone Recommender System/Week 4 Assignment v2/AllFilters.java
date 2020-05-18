import java.util.ArrayList;

public class AllFilters implements Filter {
    ArrayList<Filter> filters;
    
    public AllFilters() {
        filters = new ArrayList<Filter>();
        // needs to be initialised first
    }

    public void addFilter(Filter f) {
        //allows one to add a Filter to the ArrayList
        filters.add(f);
    }

    @Override
    public boolean satisfies(String id) {
        //f is the  name of the filter that we tend to use
        for(Filter f : filters) {
            if (! f.satisfies(id)) {
                return false;
            }
        }        
        return true;
    }

}
