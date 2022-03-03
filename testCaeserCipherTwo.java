import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
/**
 * Write a description of testCaeserCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class testCaeserCipherTwo {
    public int maxIndex (int[] vals){
        int maxDex = 0;
        for(int k = 0; k < vals.length; k++){
            if (vals[k] > vals[maxDex]){
                maxDex = k;                
            }                        
        }                
        return maxDex;
    }
    public int[] countEncryptedLetters(String encryptedString){
        int[] counts = new int[26];
        String alphLower = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < encryptedString.length(); i++){
            
            char c = Character.toLowerCase(encryptedString.charAt(i));
            int dex = alphLower.indexOf(c);
            if (dex != -1){
                counts[dex]+=1;

            }
            
            
        }

        return counts;
        }
    public String halfOfString(String message, int start){
    String everyOtherLetter = "";
    for (int i = start; i<message.length();i+=2){
        everyOtherLetter+=message.charAt(i);
        
    }
    return everyOtherLetter;       
    }
    public int getKey (String s){
    int[] countLetters = countEncryptedLetters(s);
    int maxDex = maxIndex(countLetters);
    int dkey = maxDex - 4;
    if(maxDex<4){
        dkey = 26 - (4 - maxDex);
    }
    return dkey;
    }
    
    public String breakCaeserCipherTwo(String input){       
        
        String stringFirst;
        String stringSecond;
        stringFirst = halfOfString(input, 0);
        stringSecond = halfOfString(input, 1); 
        int key1 = getKey(stringFirst);
        int key2 = getKey(stringSecond);                             
        CaeserCipherTwo ccd = new CaeserCipherTwo(key1, key2);
        System.out.println("This is the first key: " + key1);
        System.out.println("This is the second key: " + key2);
        String decrypted = ccd.decrypt(input);
        System.out.println(decrypted);
        return decrypted;
        
        
        
    }
    public void simpleTests(){
        //FileResource fr = new FileResource();
        String frAsString = "Hfs cpwewloj loks cd Hoto kyg Cyy.";
        int key1 = 14;
        int key2 = 24;
        CaeserCipherTwo cc = new CaeserCipherTwo(key1, key2);
        String toPrintE = cc.encryptTwoKeys(frAsString);
        String toPrintD = cc.decrypt(frAsString);
        System.out.println("This is the original:" + frAsString);
        System.out.println("This is the encrypted line:" + toPrintE);
        System.out.println("This is the decrypted line:" + toPrintD);
        String broke = breakCaeserCipherTwo(frAsString);
        System.out.println(broke);
        
    }
    
    
    }