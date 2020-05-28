
import java.util.*;
public class Syllables{
private int  helperS(String word, String p) {
		ArrayList<String> tokens = new ArrayList<String>();
		Pattern tokSplitter = Pattern.compile(p);
		Matcher m = tokSplitter.matcher(word);
		
		while (m.find()) {
			tokens.add(m.group());
		}
		return  tokens.size();
	}
	
	public int getNumSyllables()
	{
		List<String> words = getTokens("[a-zA-Z]+");
		// get all the words
		int sum=0;
			for(String word:words) {
				// for each word
				sum+=countSyllables(word);			
				//count syllables and add them up
			}
        return sum;
	}
	
	protected int countSyllables(String word)
	{
		word=word.toLowerCase();
		
		if(word.equals("the")) {
			return 1;
		}
		String pi="[aeiouy]+";
		int count=0;
		if(word.charAt(word.length()-1)=='e') {
			word=word.substring(0,word.length()-1);		 
		}
		 count=helperS(word, pi);		 	
		return count;
	}
}
