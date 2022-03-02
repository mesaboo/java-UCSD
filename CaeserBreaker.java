import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;

/**
 * Write a description of CaeserBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaeserBreaker {
    public String decrypt (String encrypted){
        CaeserCipher cc = new CaeserCipher();
        int[] freqs = countEncryptedLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = 0;
        if (maxDex < 4){
            dkey = 26 - (4-maxDex);

        }
        else{
            dkey = maxDex - 4;
        }
        return cc.encrypt(encrypted, 26-dkey);

        
        
    }

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
public void testDecrypt(String encryptedString){
    
    
    String decryptedMessage = decrypt(encryptedString);
    System.out.println(decryptedMessage);
    
    
    
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
public String decryptTwoKeys(String encrypted){
    
    CaeserCipher cc = new CaeserCipher();
    String stringFirst;
    String stringSecond;
    stringFirst = halfOfString(encrypted, 0);
    stringSecond = halfOfString(encrypted, 1);
    int keyFirst = getKey(stringFirst);
    int keySecond = getKey(stringSecond);        
    System.out.println("This is the first key: " + keyFirst);
    System.out.println("This is the second key: " + keySecond);
    String decrypted = cc.encryptTwoKeys(encrypted, (26 - keyFirst), (26 - keySecond));
    return decrypted;
}

public void testDecryptTwoKeys(){
    CaeserCipher cc = new CaeserCipher();
    FileResource fr = new FileResource ();
    String frString = fr.toString();
    int keyAa = 0;
    int keyBb = 0;
    for (int keyA=0; keyA < 26; keyA++){
        for (int keyB=0; keyB < 26; keyB++){
            String s = cc.encryptTwoKeys(frString, keyA, keyB);
            System.out.println(s.substring(0,50));
    
        }
    
}
}
}

