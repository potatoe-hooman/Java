
/**
 * Write a description of DistanceFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DistanceFilter implements Filter{
    private Location x;
    private double distance;
    public DistanceFilter(Location input, double range){
        x=input; distance = range;
     }
     
    public boolean satisfies(QuakeEntry qe){
        return(qe.getLocation().distanceTo(x)<distance);
    }
    
    
    public String getName(){
    return "Distance";}
}
