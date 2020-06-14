
/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class Tester {
    void testGetFollows (){
        MarkovOne mark= new MarkovOne ();
        mark.setTraining("this is a test yes this is a test.");
            ArrayList<String> ret=mark.getFollows("t");
        for(int i=0;i<ret.size();i++){
            System.out.println(ret.get(i));
        }
        System.out.println(ret.size());
    }

    void testGetFollowsWithFile(){
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovOne markov = new MarkovOne();
        markov.setTraining(st);
        ArrayList<String> ret=markov.getFollows("he");
        for(int i=0;i<ret.size();i++){
            System.out.println(ret.get(i));
        }
        System.out.println(ret.size());

    
    }
}
