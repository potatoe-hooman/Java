
/**
 * Write a description of LargestQuakes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class LargestQuakes {
    void findLargestQuakes(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        //System.out.println("read data for " + list.size());       
        // Location jakarta  = new Location(-6.211, 106.845);
        //ArrayList<QuakeEntry> close = getClosest(list, jakarta, 3);
        //for(QuakeEntry qe: list){
            //QuakeEntry entry = close.get(k);
            //double distanceInMeters = jakarta.distanceTo(entry.getLocation());
            //System.out.println(qe);
            //}
        //System.out.println("number found: " + list.size());  
        int howMany=50;
        ArrayList<QuakeEntry> findings=getLargest(list,howMany);
        for(QuakeEntry qe: findings){
            System.out.println(qe);
            }
    }
    
    int indexOfLargest(ArrayList<QuakeEntry> data){
        int index=0;
        double maxMag=0;
        //EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedatasmall.atom";        
        //ArrayList<QuakeEntry> list  = parser.read(source);
        ArrayList<QuakeEntry> list = data;
        System.out.println("read data for " + list.size());        
        for(int i=0;i<list.size();i++){
            if(maxMag<list.get(i).getMagnitude()){
                maxMag=list.get(i).getMagnitude();
                index=i;
            }            
        }
        //System.out.println(index + " " + maxMag);
        return index;
    }
    
    ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany){
        ArrayList<QuakeEntry> inputData = quakeData;
        ArrayList<QuakeEntry> outputData = new ArrayList<QuakeEntry>();
         if(howMany>quakeData.size()){
                //size of new list is elss than the number ret original
                return quakeData;
                //else the list created
        }
        for(int i= 0; i<howMany;i++){
            //iterate howMany times with indexof largest
            int currTopIndex=indexOfLargest(inputData);
            // get index and add that in arraylist to be ret
                outputData.add(inputData.get(currTopIndex));
            // remove element at tht index from quakeData index observed
            inputData.remove(currTopIndex);
        }
        
       
        return outputData;
    } 
}
