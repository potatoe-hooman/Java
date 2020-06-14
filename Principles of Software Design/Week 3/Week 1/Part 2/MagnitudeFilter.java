
/**
 * Write a description of MagnitudeFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MagnitudeFilter implements Filter
{
    private double minM; 
    private double maxM; 
    
    public MagnitudeFilter(double min, double max) { 
        minM = min;     
        maxM = max;
    } 

    public boolean satisfies(QuakeEntry qe) { 
        return (qe.getMagnitude() >= minM
                && qe.getMagnitude()<=maxM); 
    } 

    public String getName(){
    return "Magnitude";}
}
