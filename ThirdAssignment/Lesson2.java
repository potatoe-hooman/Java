
/**
 * Write a description of Lesson2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class Lesson2 {
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord coldestSoFar = null;
        for( CSVRecord currRow : parser){
            if(coldestSoFar==null){
            coldestSoFar=currRow;            
            }
            else{
                double currTemp= Double.parseDouble(currRow.get("TemperatureF"));  
                double coldest= Double.parseDouble(coldestSoFar.get("TemperatureF"));
                if (currTemp<coldest && currTemp>-460){
                coldestSoFar=currRow;                
                }
            }
        }
        
        return coldestSoFar;
    }
    
    public void testColdestHourInFIle(){
        FileResource fr= new FileResource("nc_weather/2014/weather-2014-01-03.csv");
        CSVRecord rc =coldestHourInFile(fr.getCSVParser());
        System.out.println("The Coldest Temperature FOund is found to be : " +rc.get("TemperatureF") + " at " 
                            +rc.get("DateUTC") );
        }
    
    public String fileWithColdestTemp(){
        DirectoryResource dr = new DirectoryResource();
        CSVRecord coldestSoFar = null;
        String mango =null;
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currRow= coldestHourInFile(fr.getCSVParser());
            if(coldestSoFar==null){
            coldestSoFar=currRow;  
            mango = f.toString();
            }
            else{
                double currTemp= Double.parseDouble(currRow.get("TemperatureF"));  
                double coldest= Double.parseDouble(coldestSoFar.get("TemperatureF"));
                if (currTemp<coldest && currTemp>-460){
                coldestSoFar=currRow; 
                mango = f.toString();
                }
            }
        }
        
        return mango;
        }
          
    public void testFileWIthColdestTemp(){

        String rc =fileWithColdestTemp();
        System.out.println("The Coldest FILE is  : " +rc );
        // rc is the file address in String format
        // Printing Coldest TEmp
        FileResource frct= new FileResource(rc);
        CSVRecord ctRow =coldestHourInFile(frct.getCSVParser());
        System.out.println("Coldest temperature on that day was : " +ctRow.get("TemperatureF"));
        //All the temp of the day
        // iterate to print each line
        System.out.println("All the Temperature on that day : " );
        //frct is the file resource we had been searching for
        int Count=1;
        for( CSVRecord currState : frct.getCSVParser()){
                Count =Count+1;
            System.out.println(" " +Count +" " +currState.get("DateUTC") +" " +currState.get("TemperatureF"));
        }
        }
        
    public CSVRecord lowestHumidityInFile(CSVParser parser){
         CSVRecord lowHumidRow = null;
        
        for( CSVRecord currRow : parser){
            String mango = currRow.get("Humidity");
                if (mango.equals("N/A")){
                //do nothing
                }
              else{
            if(lowHumidRow==null){
            lowHumidRow=currRow;            
            }
            else{

                double currH= Double.parseDouble(mango);  
                double lowHumid= Double.parseDouble(lowHumidRow.get("Humidity"));
                if (currH<lowHumid){
                lowHumidRow=currRow;                
                }
            }
            }
        }
       
        return lowHumidRow;
        }
        
    public void testLowestHumidityInFile(){
        FileResource fr = new FileResource("nc_weather/2014/weather-2014-06-29.csv");
        CSVRecord minHumRow = lowestHumidityInFile(fr.getCSVParser());
        // we get lowHumidRow in minHumRow
        System.out.println("Lowest Humidity was " +minHumRow.get("Humidity") +" at " +minHumRow.get("DateUTC"));
        }
        
    public CSVRecord lowestHumidityInManyFiles(){
        DirectoryResource dr = new DirectoryResource();
        CSVRecord humidSoFar = null;
        String mango;
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currRow= lowestHumidityInFile(fr.getCSVParser());
            mango = currRow.get("Humidity");
            if (mango.equals("N/A")){
                //do nothing}}
            }
            else{
            if(humidSoFar==null){
            humidSoFar=currRow;  

            }
            else{  
                double currTemp= Double.parseDouble(currRow.get("Humidity"));  
                double coldest= Double.parseDouble(humidSoFar.get("Humidity"));
                if (currTemp<coldest){
                humidSoFar=currRow; 
                }
            }}
        }
        
        return humidSoFar;
        }
          
    public void testLowestHumidityInManyFiles(){
        CSVRecord yy= lowestHumidityInManyFiles();
        System.out.println("Lowest HUmidity was " +yy.get("Humidity") +" " +yy.get("DateUTC"));
    }    
    
    public double averageTemperatureInFile( CSVParser parser){
        double mister=0.0;
        double count=0.0;
        String apple = null;
        for(CSVRecord tango : parser){
               count=count+1;
               double cogni=Double.parseDouble(tango.get("TemperatureF"));
               mister=mister+cogni;           
            }
        mister=mister/count; 
        return mister;
    }
    
    public void testAverageTemperature(){
     FileResource dew= new FileResource("nc_weather/2013/weather-2013-08-10.csv");
     CSVParser majnun= dew.getCSVParser();
     double hula=averageTemperatureInFile(majnun);
     System.out.println("Average Temperature in FIle is" +hula);
    }
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        double hiralal=0.0, count=0.0;
        double currH=0.0, currT=0.0, totalTemp=0.0;
            for( CSVRecord curr : parser){
            currH=Double.parseDouble(curr.get("Humidity"));
            if(currH>=value){
                count=count+1;
                currT=Double.parseDouble(curr.get("TemperatureF"));
                totalTemp=totalTemp+currT;
            }
           
        }
        if (count!=0){
        hiralal=totalTemp/count;
        }
        else
        {
            hiralal=0.0;
        }
                return hiralal;
    }
    
    public void testAverageTemperatureWithHighHumidityInFile(){
        FileResource meow = new FileResource("nc_weather/2013/weather-2013-09-02.csv");
        int dot =80;
        double hiralal= averageTemperatureWithHighHumidityInFile(meow.getCSVParser(), dot);
        if (hiralal==0.0){ 
            System.out.println("NO temperature with that humidity");
        }
        else {
            System.out.println("Average Temp with reference humidiy" +hiralal);
        }
        
    }
}