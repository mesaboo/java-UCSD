import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
/**
 * Write a description of allNames here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class allNames {
    public void countNames(FileResource fr){
        int mNameCount = 0;
        int fNameCount = 0;
        int mBirths = 0;
        int fBirths = 0;
        CSVParser parser = fr.getCSVParser(false);
        for (CSVRecord record: parser){
            if (record.get(1).equals("M")){
                mNameCount+=1;
                mBirths += Integer.parseInt(record.get(2));
            }
            else{
                fNameCount+=1;
                fBirths += Integer.parseInt(record.get(2));
            }
        }
        int totalNumberOfNames = mNameCount + fNameCount;
        int totalBirths = mBirths + fBirths;
        System.out.println("Number of boys names: " +mNameCount);
        System.out.println("Number of girls names: " +fNameCount);
        System.out.println("Number of total names: " +totalNumberOfNames);
        System.out.println("Number of male births: " + mBirths);
        System.out.println("Number of female births: " + fBirths);
        System.out.println("Number of births (total): " + totalBirths);
    }
    public int getRank(int year, String name, String gender){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        int mRank = 1;
        int fRank = 1;
        
        for (CSVRecord record : parser){
            if (record.get(1).equals(gender) && record.get(0).equals(name)){
                if (gender.equals("M")){
                    return mRank;
                }
                else{
                    return fRank;
                }
            }
            else{
                if (record.get(1).equals("M")){
                    mRank += 1;
                }
                else{
                    fRank += 1;
                }
                
            }
                
                
        
       
        }
        return -1;
    }
    public String getName(int year, int rank, String gender){
        int mRank = 1;
        int fRank = 1;
        String yearToCheck = "";
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        for (CSVRecord record : parser){
            if (record.get(1).equals(gender) && (mRank == rank)){
                return record.get(0);
            }
            else if (record.get(1).equals(gender) && (fRank == rank)){
                return record.get(0);
            }
            else{
                if (record.get(1).equals("M")){
                    mRank += 1;
                }
                else{
                    fRank += 1;
                }
                
            }
        }
        return "NOT FOUND";
    }
    public String yearOfHighestRank(String name, String gender){
        DirectoryResource dr = new DirectoryResource();
        int highestYear = 0;
        String highestYearAsString = "";
        int highestRank = 0;
        int currentRank = 0;
        int mRank = 1;
        int fRank = 1;
        for (File f:dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);
            for (CSVRecord record : parser){
                if (record.get(1).equals(gender) && record.get(0).equals(name)){
                    if (gender.equals("M")){
                        highestRank = mRank;
                    }
                    else{
                        highestRank = fRank;
                    }
                }
                else{
                    if (record.get(1).equals("M")){
                        mRank += 1;
                    }
                    else{
                        fRank += 1;
                    }
                }
                if (currentRank < highestRank){
                   currentRank = highestRank;
                   highestYearAsString = f.getName();
                   
                   }
                }
        }
        if (highestYearAsString.equals("")){
            return "NOT FOUND";
        }
        System.out.println(highestYearAsString);
        System.out.println(currentRank);
        return highestYearAsString;
        
    }
    public double getAverageRank(String name, String gender){
        double count = 0.0;
        int rankSum = 0;
        DirectoryResource dr = new DirectoryResource();
        
        for (File f: dr.selectedFiles()){
            int mRank = 1;
            int fRank = 1;
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);
            for (CSVRecord record : parser){
                if (record.get(1).equals(gender) && record.get(0).equals(name)){
                    if (gender.equals("M")){
                        rankSum += mRank;
                        count += 1.0;
                    }
                    else{
                        rankSum += fRank;
                        count += 1.0;
                    }   
                }
                else{
                    if (record.get(1).equals("M")){
                        mRank += 1;
                    }
                    else{
                        fRank += 1;
                    }
                
                }
                      
        
            }
        }
        if (rankSum == 0){
            return -1.0;
        }
        else{
        double AverageRank = rankSum/count;
        return AverageRank;
        }
        }
    public int getTotalBirthsRankedHigher(int year, String name, String gender){
        int totalBirths = 0;
        
        int rank = getRank(year, name, gender);
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        for (CSVRecord record:parser){
            if (record.get(1).equals(gender) && record.get(0).equals(name)){
                    if (gender.equals("M")){
                        return totalBirths;
                    }
                    else{
                        return totalBirths;
                    }   
                }
                else{
                    if (record.get(1).equals("M") && record.get(1).equals(gender)){
                        
                        totalBirths += Integer.parseInt(record.get(2));
                    }
                    if (record.get(1).equals("F") && record.get(1).equals(gender)){
                        
                        totalBirths += Integer.parseInt(record.get(2));
                    }
                }
        }
        return -1;
        }
    public void whatIsNameInYear(String name, Integer year, Integer newYear, String gender){
        int oldRank = getRank(year, name, gender);
        String newName = getName(newYear, oldRank, gender);
        String oldYear = String.valueOf(year);
        String newYearAsString = String.valueOf(newYear);
        System.out.println(name+" born in "+oldYear+" would be "+newName+" in "+newYearAsString+"."); 
    }
    public void testNames(){
        FileResource fr = new FileResource();
        countNames(fr);
        
        
        
    }
}




