
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class WordLengths {
    
   int[] countWordLengths(FileResource resource, int[] counts){
    
    for( String item:resource.words()){
      int index = item.length();
      if(index>counts.length){
        counts[counts.length-1]+=1;
      }
        else {
        counts[index]+=1;
        }
        
    }
    return counts; 
    }
    
   int indexOfMax(int[] values){
       int maxPositionValue=0;
       int maxPos=0;
       for(int i=0; i<values.length;i++){
        if(maxPositionValue<values[i]){
        maxPositionValue=values[i];
        maxPos=i;        
        }
        }
       return maxPos;
    }
     
   void testCountWordLenghs(){
    FileResource resource= new FileResource(); 
    int[] counts =  new int[31];
    counts=countWordLengths(resource, counts);
    
    for(int i=0; i<counts.length;i++){
        System.out.println("Count "+i+" "+counts[i]);
        }
    int mega=indexOfMax(counts);
    System.out.println("Max Index Position: " +mega);
    } 
    
}
