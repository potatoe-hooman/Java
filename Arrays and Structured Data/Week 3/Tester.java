
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    public void testUniqueIP(){
        LogAnalyzer logA = new LogAnalyzer();
        logA.readFile("weblog2_log");
        int count=logA.countUniqueIPs();
        System.out.println("Unique IPs found : " +count);
    }    
    public void testPrintAllHigher(){
        LogAnalyzer logA = new LogAnalyzer();
        logA.readFile("weblog2_log");
        int lower= 400;
        logA.printAllHigherThanNum(lower);

    }
    public void testUniqueIPVisitsOnDay(){
        LogAnalyzer logA = new LogAnalyzer();
        logA.readFile("weblog2_log");
        String checker="Sep 24";
        ArrayList<String> persons=logA.uniqueIPVisitsOnDay(checker);
        for(String s:persons){
            System.out.println(s);
           
        }
                    System.out.println(persons.size());
    }
    public void testCountUniqueIPsInRange(){
        LogAnalyzer logA = new LogAnalyzer();
        logA.readFile("weblog2_log");
        int low= 200;
        int high =299;
        int count=logA.countUniqueIPsInRange(low,high);
        System.out.println("Unique IPs found in the given range : " +count);
    } 
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer logA = new LogAnalyzer();
        logA.readFile("weblog2_log");
        logA.printAll();
    }
    public void testCountVisitsPerIP() {
        // complete method
                LogAnalyzer logA = new LogAnalyzer();
                        logA.readFile("weblog2_log");
        HashMap<String, Integer> mojito= logA.countVisitPerIP();
        System.out.println(mojito);
    }
    public void testIPsMostVisits(){
         LogAnalyzer logA = new LogAnalyzer();
         logA.readFile("weblog2_log");
        ArrayList tom= logA.iPsMostVisits(logA.countVisitPerIP());
        System.out.println(tom);
    }
     public void testMostNumberVisitsByIP() {

         LogAnalyzer logA = new LogAnalyzer();
         logA.readFile("weblog2_log");
        int moji= logA.mostNumberVisitsByIP(logA.countVisitPerIP());
        System.out.println("Max Occurence by an IP" +moji);
    }
    
    public void testiPsForDays(){
        LogAnalyzer logA = new LogAnalyzer();
         logA.readFile("weblog2_log");
        HashMap<String,ArrayList<String>> marconi= logA.iPsForDays();
        for(String s: marconi.keySet()){
        System.out.println("Date" +s +" " +marconi.get(s));
       }
    }
    
    public void testdayWithMostIPVisits(){
         LogAnalyzer logA = new LogAnalyzer();
         logA.readFile("weblog2_log");
         String answer=logA.dayWithMostIPVisits(logA.iPsForDays());
         System.out.println(answer);
    }
    
     public void testIPswithMostVisitsOnDay(){
         LogAnalyzer logA = new LogAnalyzer();
         logA.readFile("weblog2_log");
         String day="Sep 30";
                 HashMap<String,ArrayList<String>> marconi= logA.iPsForDays();
         ArrayList<String> answer=logA.iPsWithMostVisitsOnDay(marconi,day);
         System.out.println(answer);
    }
}
