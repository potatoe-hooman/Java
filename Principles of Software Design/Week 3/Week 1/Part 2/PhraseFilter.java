
/**
 * Write a description of PhraseFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhraseFilter implements Filter {
    
    String indicate = "";
    String phrase = "";
    public PhraseFilter(String spot, String el){
        indicate = spot;
        phrase = el; 
    }
    
    public boolean satisfies(QuakeEntry qe){
        String currTitle=qe.getInfo();
        if (currTitle.contains(phrase)){
                int phraseLen=phrase.length();
                
                if(indicate.equals("end")){
                      if(currTitle.substring(currTitle.length()-phrase.length()).equals(phrase))
                      return true;
                }
                
                if(indicate.equals("start")){
                      if(currTitle.substring(0,phrase.length()).equals(phrase))
                      return true;
                     }                    
                 
                if(indicate.equals("any")){                                    
                      return true;
                   }

            }
            return false;
    }
    
    
    public String getName(){
    return "Phase";}
}
