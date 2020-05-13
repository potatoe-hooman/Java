
/**
 * Write a description of DirectorsFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DirectorsFilter implements Filter{
    private String dNames[];
    public DirectorsFilter(String name){
        dNames=name.split(",");
    }
    
    @Override
    public boolean satisfies(String id){
        for(String s : dNames){
            if(MovieDatabase.getDirector(id).equals(s)){
                return true;
            }
        }
        return false; 
    }
}
