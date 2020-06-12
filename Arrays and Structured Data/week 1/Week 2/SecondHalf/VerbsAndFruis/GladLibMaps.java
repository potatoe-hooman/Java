import edu.duke.*;
import java.util.*;

public class GladLibMaps {
    private HashMap<String,ArrayList<String>> alter;
    /* private ArrayList<String> adjectiveList;
    private ArrayList<String> nounList;
    private ArrayList<String> colorList;
    private ArrayList<String> countryList;
    private ArrayList<String> nameList;
    private ArrayList<String> animalList;
    private ArrayList<String> timeList;
    private ArrayList<String> verbList;
    private ArrayList<String> fruitList; */
    private ArrayList<String> recorder; 
    
    private Random myRandom;
    
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
    
    public GladLibMaps(){
         alter= new HashMap<String,ArrayList<String>>() ;
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();

        recorder= new ArrayList<String>();
    }
    
    public GladLibMaps(String source){
                        alter= new HashMap<String,ArrayList<String>>() ;
        initializeFromSource(source);
        myRandom = new Random();

    }
    
    private void initializeFromSource(String source) {
        ArrayList<String> categories = new ArrayList<String>(
            Arrays.asList("adjective","noun", "color","country",
            "name","animal","timeframe","verb", "fruit")
        );
        
        for(String s : categories ){
            ArrayList<String> temp= new ArrayList<String>();
            temp=readIt(source +"/" +s +".txt");

            alter.put(s,temp);
        }
        /*adjectiveList= readIt(source+"/adjective.txt"); 
        nounList = readIt(source+"/noun.txt");
        colorList = readIt(source+"/color.txt");
        countryList = readIt(source+"/country.txt");
        nameList = readIt(source+"/name.txt");      
        animalList = readIt(source+"/animal.txt");
        timeList = readIt(source+"/timeframe.txt");   
        verbList = readIt(source+"/verb.txt");   
        fruitList = readIt(source+"/fruit.txt");     */
        
    }
    
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
        if(alter.containsKey(label)){
            for(String s : alter.keySet()){
                if(s.equals(label)){
                    return randomFrom(alter.get(s));
                }
            }
        }
        /*if (label.equals("country")) {
            return randomFrom(countryList);
        }
        if (label.equals("color")){
            return randomFrom(colorList);
        }
        if (label.equals("noun")){
            return randomFrom(nounList);
        }
        if (label.equals("name")){
            return randomFrom(nameList);
        }
        if (label.equals("adjective")){
            return randomFrom(adjectiveList);
        }
        if (label.equals("animal")){
            return randomFrom(animalList);
        }
        if (label.equals("timeframe")){
            return randomFrom(timeList);
        }
        if (label.equals("verb")){
            return randomFrom(verbList);
        }
        if (label.equals("fruit")){
            return randomFrom(fruitList);
        } */
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        return "**UNKNOWN**";
    }
    
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));

            if(recorder.contains(sub)){
                //call again 
                processWord(w);
            }
            else{
                recorder.add(sub);
            }
        
            return prefix+sub+suffix;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    
    public void makeStory(){
        recorder.clear();
        System.out.println("\n");
        String story = fromTemplate("data/madtemplate2.txt");
        printOut(story, 60);
       
         System.out.println("\n Substititution made : " +recorder.size());
        //for(int i=0; i<recorder.size();i++){
        //        System.out.println("\n"+recorder.get(i));
        //}
        System.out.println("Total words found so far" +totalWordsInMap());
    }
    
    int totalWordsInMap(){
        int total=0;
        for(String s : alter.keySet()){
            total+=alter.get(s).size();
        }
        return total;
    }
    
  

}
