import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
/**
 * Write a description of CaeserCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaeserCipher {
    private String Alphabet;
    private String lowercaseAlphabet;
    private String newKeyUpper;
    private String newKeyLower;
    private String secondKeyUpper;
    private String secondKeyLower;
    private int key;
    public String encrypt(String input){
        StringBuilder encryptedText = new StringBuilder(input.toUpperCase());
        for (int i = 0; i < input.length(); i++){   
            char currChar = encryptedText.charAt(i);
            int indexChar = Alphabet.indexOf(currChar);
            if (indexChar != -1){
               if (Character.isUpperCase(input.charAt(i))){ 
               char newCharupper = newKeyUpper.charAt(indexChar);
               encryptedText.setCharAt(i,newCharupper);
               }
               else{
               char newCharlower = newKeyLower.charAt(indexChar);
               encryptedText.setCharAt(i,newCharlower);    
               }
             }       
        }
        String encryptedString = encryptedText.toString();
        return encryptedString;
    }    
    public String decrypt(String input){
        CaeserCipher cc = new CaeserCipher(26-key);
        String decryptedString = cc.encrypt(input);
        return decryptedString;
        
        
    }
    public CaeserCipher(int key){
        Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        lowercaseAlphabet = "abcdefghijklmnopqrstuvwxyz";
        newKeyUpper = Alphabet.substring(key)+Alphabet.substring(0,key);
        newKeyLower = lowercaseAlphabet.substring(key)+lowercaseAlphabet.substring(0,key);
        this.key = key;
        
    }
    
    
    public String encryptTwoKeys(String input, int key1, int key2){
        StringBuilder encryptedTwoKeys = new StringBuilder(input.toUpperCase());       
        secondKeyUpper = Alphabet.substring(key2)+Alphabet.substring(0,key2);
        secondKeyLower = lowercaseAlphabet.substring(key2)+lowercaseAlphabet.substring(0,key2);
        for (int i = 0; i < input.length(); i++){   
            char currChar = encryptedTwoKeys.charAt(i);
            int indexChar = Alphabet.indexOf(currChar);
            if (indexChar != -1){
               if (i%2==0){              
                   if (Character.isUpperCase(input.charAt(i))){ 
                       char newCharupper = newKeyUpper.charAt(indexChar);
                       encryptedTwoKeys.setCharAt(i,newCharupper);
                   }
                   else{
                        char newCharlower = newKeyLower.charAt(indexChar);
                        encryptedTwoKeys.setCharAt(i,newCharlower);    
                   }
               }
               else{
                   if (Character.isUpperCase(input.charAt(i))){ 
                       char newCharupper = secondKeyUpper.charAt(indexChar);
                       encryptedTwoKeys.setCharAt(i,newCharupper);
                   }
                   else{
                       char newCharlower = secondKeyLower.charAt(indexChar);
                       encryptedTwoKeys.setCharAt(i,newCharlower);    
                   }                 
               }        
            }
        
        }
        String encryptedString = encryptedTwoKeys.toString();
        return encryptedString;
    }
        
    
}