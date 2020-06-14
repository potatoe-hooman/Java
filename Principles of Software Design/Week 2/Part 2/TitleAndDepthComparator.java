
/**
 * Write a description of TitleAndDepthComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class TitleAndDepthComparator implements Comparator<QuakeEntry>{   
    
    public int compare(QuakeEntry q1, QuakeEntry q2) {
            if(q1.getInfo().compareTo(q2.getInfo())>0){
                return 1;
            }
            if(q1.getInfo().compareTo(q2.getInfo())<0){
                return -1;
            }
            else{
                if(q1.getDepth()>q2.getDepth()){
                    return 1;
                }
                if(q1.getDepth()>q2.getDepth()){
                    return -1;
                }               

            }
            return 0;           
    }
    
}
