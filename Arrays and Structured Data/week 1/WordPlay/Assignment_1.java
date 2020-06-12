
/**
 * Write a description of Assignment_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Assignment_1 {
    public boolean isVowel(char ch){
        boolean truth= false;
        String vowels="aeiouAEIOU";
        int len=vowels.length();
        for(int i=0; i<len; i++){
            char current= vowels.charAt(i);
         if(ch==current)
                  {
               truth=true;
               
         }

    }
             return truth;
  }
  public  String replaceVowels(String phrase, char ch){
   
      int len=phrase.length();
      StringBuilder sb=new StringBuilder();
      sb.append(phrase);
      for(int i=0;i<len;i++)
      {
          char currChar = sb.charAt(i);
         boolean trigger=isVowel(currChar);
        if(isVowel(currChar)){
            sb.setCharAt(i,ch);
            
        }
        }
            return sb.toString();
    }
  public  String emphasize(String phrase, char ch){
   
      int len=phrase.length();
      StringBuilder sb=new StringBuilder();
      sb.append(phrase);
      for(int i=0;i<len;i++)
      {
        /*  char currChar = sb.charAt(i);
         boolean trigger=isVowel(currChar);
        if(isVowel(currChar)){
            sb.setCharAt(i,ch);            
        }*/
        boolean faith = (ch==sb.charAt(i));
   
        if( faith && i%2==0){
   
            sb.setCharAt(i,'*'); 
        }
        
        if(faith && i%2==1){
            sb.setCharAt(i,'+'); 
        }
    }
            return sb.toString();
    }
    //Calling and Testing Funtions
    //1. Write a method isVowel that has one Char parameter named ch. This method returns true if ch is a vowel (one of 'a', 'e', 'i', 'o', or 'u' or the uppercase versions) and false otherwise. You should write a tester method to see if this method works correctly. For example, isVowel(‘F’) should return false, and isVowel(‘a’) should return true.
  public void callIsVowel(){
      char passme='d';
    boolean answer=isVowel(passme);
    System.out.println("Is the character passed a Vowel? " +answer);
    }
    //2. Write a method replaceVowels that has two parameters, a String named phrase and a Char named ch. This method should return a String that is the string phrase with all the vowels (uppercase or lowercase) replaced by ch. For example, the call replaceVowels(“Hello World”, ‘*’) returns the string “H*ll* W*rld”. Be sure to call the method isVowel that you wrote and also test this method.
  public void callReplaceVowels(){
      String phrase="Hello World";
      char passme='*';
    String a =replaceVowels(phrase,passme);
    System.out.println("Updated Phrase : " +a);
    }
    //3.     Write a method emphasize with two parameters, a String named phrase and a character named ch. This method should return a String that is the string phrase but with the Char ch (upper- or lowercase) replaced by

        //‘*’ if it is in an odd number location in the string (e.g. the first character has an odd number location but an even index, it is at index 0), or

            //‘+’ if it is in an even number location in the string (e.g. the second character has an even number location but an odd index, it is at index 1).

                //For example, the call emphasize(“dna ctgaaactga”, ‘a’) would return the string “dn* ctg+*+ctg+”, and the call emphasize(“Mary Bella Abracadabra”, ‘a’) would return the string “M+ry Bell+ +br*c*d*br+”. Be sure to test this method.
  public void callEmphasize(){
      String phrase="dna ctgaaactga";
      char passme='a';
    String a =emphasize(phrase,passme);
    System.out.println("Updated Phrase : " +a);
    }
}