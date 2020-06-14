
/**
 * Write a description of class QuakeSortInPlace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class QuakeSortInPlace {

    public QuakeSortInPlace() {
        // TODO Auto-generated constructor stub

    }
    public int getLargestDepth(ArrayList<QuakeEntry> quakes, int from){
        int indexPos=from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getDepth() > 
                quakes.get(indexPos).getDepth()) {
                indexPos = i;
            }
        }
        return indexPos;
    }
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }
    
    public void sortByMagnitude(ArrayList<QuakeEntry> in) {
       
       for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
        }
        
    }

    public void sortByLargestDepth(ArrayList<QuakeEntry> in) {
       
       for (int i=0; i<70; i++) {
            int maxIndex = getLargestDepth(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(maxIndex);
            in.set(i,qmin);
            in.set(maxIndex,qi);
        }
        
    }

    public void testSortDepth() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/earthQuakeDataDec6sample2.atom";
        //String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");    
        //sortByMagnitude(list);
        sortByLargestDepth(list);
        
        for (QuakeEntry qe: list) { 
            System.out.println(qe);
        } 
        
    }
    
    public void testSort() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
       
        System.out.println("read data for "+list.size()+" quakes");    
        sortByMagnitude(list);
        for (QuakeEntry qe: list) { 
            System.out.println(qe);
        } 
        
    }
    
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }
    
    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                              qe.getLocation().getLatitude(),
                              qe.getLocation().getLongitude(),
                              qe.getMagnitude(),
                              qe.getInfo());
        }
        
    }
    
    public void onePassBubbleSort(
    ArrayList<QuakeEntry> quakeData, int numSorted){
        for(int i=0;i<quakeData.size()-numSorted;i++){
            double qi=quakeData.get(i).getMagnitude();
            double qiNext=quakeData.get(i+1).getMagnitude();
            if(qi>qiNext){
                quakeData.set(i,quakeData.get(i+1));
                quakeData.set(i+1,quakeData.get(i));
            }
        }        

    }
    void sortByMagnitudeWithBubbleSort (ArrayList<QuakeEntry> in){
            // call onpass n-1 times
            for(int i=1;i<in.size();i++){
                onePassBubbleSort(in,i);            
            }
            
            //printout to check output anytime you wish
    }
    public void testSortAssignment2() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
       
        System.out.println("read data for "+list.size()+" quakes");    
        sortByMagnitudeWithBubbleSort(list);
        for (QuakeEntry qe: list) { 
            System.out.println(qe);
        } 
        
    }
    
    public boolean checkInSortedOrder (ArrayList<QuakeEntry> quakeData){
        for(int i=0;i<quakeData.size()-1;i++){
            double qi=quakeData.get(i).getMagnitude();
            double qiNext=quakeData.get(i+1).getMagnitude();
            if(qi>qiNext){
                return false;
            }
        }
        return true;
    }
    
    /*
    void sortByMagnitudeWithBubbleSortWithCheck(ArrayList<QuakeEntry> in,int counter){

        if(checkInSortedOrder(in)){         
        }
        else
            {
             onePassBubbleSort(in,1);
             counter+=1;
             sortByMagnitudeWithBubbleSortWithCheck(in,counter);
            }
          System.out.println("Sorting Attempted " +counter 
                + " number of times.");  
                
    }
    */ /* */
    
    void sortByMagnitudeWithBubbleSortWithCheck(ArrayList<QuakeEntry> in){
        int counter=0;
        for(int i=0;i<in.size();i++){
            if(checkInSortedOrder(in)==true){   
                System.out.println("Sorting Attempted " +counter
                + " number of times.");  
                break;
        }
        else
            {
             onePassBubbleSort(in,1+i);             
             counter++;
            }
        
        }
        
                
    }
    public void testSortAssignment3() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/earthQuakeDataWeekDec6sample2.atom";
        //String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);        
        System.out.println("read data for "+list.size()+" quakes");    
        sortByMagnitudeWithBubbleSortWithCheck(list);
       // for (QuakeEntry qe: list) { 
         //   System.out.println(qe);
        //}         
    }
    void sortByMagnitudeWithCheck (ArrayList<QuakeEntry> in){
        for(int i=0;i<in.size();i++){
            if(checkInSortedOrder(in)){
                System.out.println("Took " +i + " swaps.");
                break;
            }
            else{
                int minIdx = getSmallestMagnitude(in,i);
                QuakeEntry qi = in.get(i);
                QuakeEntry qmin = in.get(minIdx);
                in.set(i,qmin);
                in.set(minIdx,qi);     
            }
        }
    }
    
    void testAssignment3(){
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/earthQuakeDataWeekDec6sample1.atom";
        //String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);        
        System.out.println("read data for "+list.size()+" quakes");    
        sortByMagnitudeWithCheck(list);
        //for (QuakeEntry qe: list) { 
        //    System.out.println(qe);
        //}
    
    }
    
    
    }
