import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {
    public boolean isVowel(char ch){
        char character = Character.toLowerCase(ch);
        if (character =='a' || character=='e' || 
        character =='i' || character =='o' ||
        character =='u'){
            return true;
            
    
        }
        return false;
    }
    public String replaceVowels(String phrase, char ch){
        StringBuilder stringWithoutVowels = new StringBuilder(phrase);
        for (int i = 0; i< phrase.length();i++){
           if (isVowel(stringWithoutVowels.charAt(i))){
               stringWithoutVowels.setCharAt(i,ch);
               
            }
            
        }
        return stringWithoutVowels.toString();
        
    }
    public String emphasize (String phrase, char ch){
        StringBuilder emphasize = new StringBuilder(phrase);
        for (int i = 0 ; i < emphasize.length() ; i++){
            if (emphasize.charAt(i) == ch){
                // Looking for odd number location not index
                if (i%2 == 0){
                    emphasize.setCharAt(i, '*');
                }
                else{
                    emphasize.setCharAt(i, '+');
                }
            }     
        }
        return emphasize.toString();
    }
    public void testIsVowel(){
        // Insert a vowel
        System.out.println(isVowel('f'));
    }
}
