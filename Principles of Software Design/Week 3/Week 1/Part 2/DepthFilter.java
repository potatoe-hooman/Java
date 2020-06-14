
/**
 * Write a description of DepthFIlter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */ 
public class DepthFilter implements Filter
{
    private double minM; 
    private double maxM; 
    
    public DepthFilter(double min, double max) { 
        minM = min;     
        maxM = max;
    } 

    public boolean satisfies(QuakeEntry qe) { 
        return (qe.getDepth() >= minM
                && qe.getDepth()<=maxM); 
    } 

    
    public String getName(){
    return "Depth";}

}
