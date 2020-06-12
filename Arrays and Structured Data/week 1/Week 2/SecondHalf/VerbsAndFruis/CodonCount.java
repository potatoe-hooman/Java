
/**
 * Write a description of CodonCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class CodonCount {
    
    private HashMap<String,Integer> map;
    
    public CodonCount(){
        map= new HashMap<String,Integer>();
        
    }
    
    void buildCodonMap(int start, String dna){
       map.clear();
       int index=start;
       int len= dna.length();
       while(index<len){
        if(index>=0 &&index<len-3){
            String codon = dna.substring(index,index+3);
            if(map.containsKey(codon)){
                    map.put(codon,map.get(codon)+1);
            }
            else{
                    map.put(codon,1);
            }
            index=index+3;
        }
        else{
          break;
        }
      }
    }
    
    String getMostCommonCodon(){
        int currValue =0 ;
        int count=0;
        String answer ="";
        for(String s: map.keySet()){
            currValue=map.get(s);
            if(count<currValue){
                count=currValue;
                answer=s;
            }
        }
        return answer;
    }
    
    void printCodonCounts(int start, int end)
    {
        for(String s: map.keySet()){
            if(map.get(s)>=start && map.get(s)<=end){
                System.out.println(s +" " +map.get(s));
            }
        }
    }
    
    void tester(){
        FileResource fr=new FileResource();
        String input=fr.asString().toUpperCase().trim();
        int a,b; a=1; b=5;
        for(int i=0;i<3;i++){
            buildCodonMap(i,input);
            System.out.println("Reading frame starting with " 
                 +i +" results in "+map.size()  +" unique codons");
            String cmn=getMostCommonCodon();
            System.out.println("and most common codon is " 
                    +cmn +" with count "+map.get(cmn));
            System.out.println("Counts of codons between " 
                    +a +" and " +b +" inclusive are: " );
            printCodonCounts(6,8);
            
            System.out.printf("\n \n");
                 
        }
    }
}
