
/**
 * Write a description of TitleLastAndMagnitudeComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
/**
 * Write a description of TitleAndDepthComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class TitleLastAndMagnitudeComparator  implements Comparator<QuakeEntry>{   
    
    public int compare(QuakeEntry q1, QuakeEntry q2) {
            String[] s1 =q1.getInfo().split(" "); 
            String[] s2 =q2.getInfo().split(" ");
            String a =s1[s1.length-1];

            String b =s2[s2.length-1];

            if(a.compareTo(b)>0){
                return 1;
            }
            if(a.compareTo(b)<0){
                return -1;
            }
            else{
                if(q1.getMagnitude()>q2.getMagnitude()){
                    return 1;
                }
                if(q1.getMagnitude()<q2.getMagnitude()){
                    return -1;
                }               

            }
            return 0;           
    }
    
}
