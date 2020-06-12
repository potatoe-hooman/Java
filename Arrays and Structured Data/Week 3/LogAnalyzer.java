
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
         // complete constructor
     }
     
     public int countUniqueIPs(){
        
        ArrayList<String> IPList = new ArrayList<String>();
        for(int i =0; i<records.size(); i++){
            LogEntry le= records.get(i);
             String currIP= le.getIpAddress();
           if(!IPList.contains(currIP)){
               IPList.add(currIP);
            }
        }
        return IPList.size();
        }
        
     void printAllHigherThanNum(int num){
         for(int i =0; i<records.size(); i++){
            LogEntry le= records.get(i);
             int stC= le.getStatusCode();
           if(stC>num){
               System.out.println(le.toString());
            }
            }
        }
     public ArrayList<String> uniqueIPVisitsOnDay(String someday){
         ArrayList<String> persons= new ArrayList<String>();
         for(int i =0; i<records.size(); i++){
            LogEntry le= records.get(i);
            String currIP= le.getIpAddress();
            String d=le.getAccessTime().toString();
            //String date=le.
           if(!persons.contains(currIP) && d.contains(someday)){
               persons.add(currIP);
            }
            }
            return persons;
        }   
        
     public int countUniqueIPsInRange(int low, int high){
         ArrayList<String> persons= new ArrayList<String>();
         for(int i =0; i<records.size(); i++){
           LogEntry le= records.get(i);
           String currIP= le.getIpAddress();
           int stc= le.getStatusCode();
            //String date=le.
           if(!persons.contains(currIP) && stc<=high && stc>=low ){
               persons.add(currIP);
            }
            }
            return persons.size();
        }   
     
       public HashMap<String,Integer> countVisitPerIP(){
        HashMap<String, Integer> mojito = new HashMap<String, Integer>();
        for(LogEntry le: records){
           String currIP= le.getIpAddress();
           if(!mojito.containsKey(currIP)){
               mojito.put(currIP,1);
            }
            else{
                ;
                mojito.put(currIP,mojito.get(currIP)+1);
                        } 
        }
        return mojito;       
     } 
     
         public HashMap<String,ArrayList<String>> iPsForDays(){
        HashMap<String, ArrayList<String>> magnum = new HashMap<String, ArrayList<String>>();
        for(LogEntry le: records){

           String currIP= le.getIpAddress();
           String date= le.getAccessTime().toString().substring(4,11);
           //HashMap stores (date, list of ips)
           if(!magnum.containsKey(date)){
               ArrayList<String> tempo= new ArrayList<String>();               
               tempo.add(currIP);
               magnum.put(date,tempo);
            }
           else{
               ArrayList<String> oldList = magnum.get(date);
               oldList.add(currIP);                
               magnum.put(date,oldList);
            }
          
        }
        return magnum;       
     } 
     
     public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> mojojo){
        ArrayList<String> ipl = new ArrayList<String>();
        String day="";
        int maxWidth=0;
        for(String s: mojojo.keySet()){
            int currWidth=mojojo.get(s).size();
                if(maxWidth<currWidth){
                    day=s;
                    maxWidth=currWidth;
                }            
        }
        return day;
        }
     
     public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String,ArrayList<String>> maggie,String day ){

         // create a base of counts of each ip
         System.out.println(maggie);
         System.out.println(day);
         ArrayList<String> ipl=new ArrayList<String>();

         for(String date: maggie.keySet()){
             if(date.contains(day)){
                 ipl=maggie.get(date);
                }
            }
         System.out.println(ipl);
         HashMap<String,Integer> jerry= new HashMap<String,Integer>(); 
         
         for(String s: ipl){
             if(jerry.containsKey(s))
             {  int count = jerry.get(s);
                jerry.put(s,count+1);
                }                
             else{
                   jerry.put(s,1);
                }
            }

         // find those with max visiits
            return iPsMostVisits(jerry);
    
        }   
        
     public int mostNumberVisitsByIP(HashMap<String,Integer> jojo){

        int max=0;
        for(String s: jojo.keySet()){
            int temp=jojo.get(s);
            if(max<temp){
                max=temp;
            }
        }
        return max;
        }
     
     public ArrayList<String> iPsMostVisits(HashMap<String, Integer> jerry){
         ArrayList<String> tom = new ArrayList<String>();
         int maxC=mostNumberVisitsByIP(jerry);
         for(String s: jerry.keySet()){
            if(jerry.get(s)>=maxC){
                tom.add(s);
            }

        }
        return tom;
      }   
      
      public void readFile(String filename) {
                  // complete method
         FileResource fr= new FileResource(filename);
         for(String item: fr.lines()){
            LogEntry lg =  WebLogParser.parseEntry(item);
            records.add(lg);
            } 
     }
     
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}
