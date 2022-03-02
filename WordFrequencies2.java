import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
import java.util.*;
/**
 * Write a description of WordFrequencies2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordFrequencies2 {

    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    private WordFrequencies2(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();                             
    }
    private void findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();
        
        for (String s:fr.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if (index == -1){
                myWords.add(s);
                myFreqs.add(1);
            }
            else{
            int value = myFreqs.get(index);
            myFreqs.set(index, value+1);
        }
        }
    }
    public int findIndexOfMax(){
        int max = 0;
        int indexValue = 0;
        for (int k=0; k < myWords.size();k++){
            if (myFreqs.get(k) > max){
                max = myFreqs.get(k);
                indexValue = k;
                
            }
            
            
        }
        return indexValue;
    }
    public void tester(){
        findUnique();
        System.out.println("# of unique words:" + myWords.size());
        for (int k=0; k< myWords.size();k++){
          System.out.println(myFreqs.get(k)+"\t"+myWords.get(k));  
        }
        int most = findIndexOfMax();
        System.out.println("Most frequest word:" + myWords.get(most));
        }
        
}

