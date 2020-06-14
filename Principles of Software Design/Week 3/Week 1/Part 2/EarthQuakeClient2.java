import java.util.*;
import edu.duke.*;

public class EarthQuakeClient2 {
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        
        return answer;
    } 

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        Location TK = new Location(39.7392, -104.9903); 
        //Filter f1= new DistanceFilter(TK,1000000);
        //Filter f2= new PhraseFilter("any","a");
        Filter f1 = new MagnitudeFilter(3.5,4.5);
        Filter f2 = new DepthFilter(-55000.0,-20000.0);
        
        ArrayList<QuakeEntry> m7  = filter(list, f1); 
        ArrayList<QuakeEntry> m6  = filter(m7, f2); 
        for (QuakeEntry qe: m6) { 
            System.out.println(qe);
        } 
                    System.out.println(m6.size());
    }

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
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

    void testMatchAllFilter (){
        EarthQuakeParser parser = new EarthQuakeParser(); 
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("Size of list" +list.size());
        MatchAllFilter maf = new MatchAllFilter();
        maf.addFilter(new MagnitudeFilter(1.0,4.0));
        maf.addFilter(new DepthFilter(-180000.0,-30000.0));
        maf.addFilter(new PhraseFilter("any","0"));
        ArrayList<QuakeEntry> quk=filter(list,maf);
        for( QuakeEntry qq: quk){
            System.out.println(qq);
        }
                System.out.println("Size " +quk.size());
        String names= maf.getName();
        
                System.out.println("Filters Used " +names);
        
    }

    void testMatchAllFilter2 (){
        EarthQuakeParser parser = new EarthQuakeParser(); 
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("Size of list" +list.size());
        MatchAllFilter maf = new MatchAllFilter();
        maf.addFilter(new MagnitudeFilter(0.0,5.0));
        maf.addFilter(new DistanceFilter(
            new Location(55.7308, 9.1153),3000000 ));
        maf.addFilter(new PhraseFilter("any","e"));
        ArrayList<QuakeEntry> quk=filter(list,maf);
        for( QuakeEntry qq: quk){
            System.out.println(qq);
        }
        System.out.println("Size " +quk.size());
        String names= maf.getName();
        
                System.out.println("Filters Used " +names);
        
    
    }
}


