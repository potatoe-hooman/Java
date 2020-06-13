
package javaapplication9;
/**
 * @author Sarthak
 */
 /* Problem
 To find if a given colour is there in the rainbow.
 To print if it does, or its variant.
 */
 
import java.util.*;
public class JavaApplication9 {
      //	 * @param args the command line arguments
	public static void main(String[] args) {
		  // TODO code application logic here
		String[] rainbow= {"violet","indigo","blue","green","yellow","orange","red"};
		Scanner scr = new Scanner(System.in);
		String input= scr.nextLine();
      // to read whole line including space
		for(String s : rainbow){
			if(input.contains(s)){
				if(input.equals(s)){
          System.out.println("It is one of a colour of rainbow.");
          break;
        }
			    System.out.println("Fainter rainbow.");				
			  break;
			}
		}
	}
}	
	

