
/**
 * Write a description of MinutesFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinutesFilter implements Filter{
        private int setMin;
        private int setMax;
    public MinutesFilter(int min, int max){
        setMin=min;
        setMax=max;
    }
        
    @Override
    public boolean satisfies(String id){
        int currDur=MovieDatabase.getMinutes(id);
        return (currDur>=setMin &&  currDur<=setMax);       
        
    }
}
