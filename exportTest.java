import edu.duke.*;
import org.apache.commons.csv.*;

/**
 * Write a description of exports here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class exportTest {
    public String countryInfo (CSVParser Parser, String country){
        CSVParser parser = Parser;
        
        for (CSVRecord record : parser){
            String exports = record.get("Exports");
            String countryInCSV = record.get("Country");
            if (countryInCSV.contains(country))
            {      
            return record.get("Country")+": "+exports +" : " +record.get("Value (dollars)");
            
            }
            
        }
        return "NOT FOUND";
            
    }
    public void listExportersTwoProducts (CSVParser parser, String exportItem1, String exportItem2){
        CSVParser twoProductsParser = parser;
        for (CSVRecord record : twoProductsParser){
        
            String exports = record.get("Exports");
            if (exports.contains(exportItem1)&&exports.contains(exportItem2)){
                System.out.println(record.get("Country"));
        
            }
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem){
        int count = 0;
        for (CSVRecord record: parser){
            
            String exports = record.get("Exports");
            if (exports.contains(exportItem)){
                count+=1;
        
            }
        }
        return count;
    
    }
    public void bigExporters(CSVParser parser, String amount){
        CSVParser bigExporterParser = parser;
        int amountLength = amount.length();
        for (CSVRecord record: bigExporterParser){
            String exportAmount = record.get("Value (dollars)");
            String country = record.get("Country");
            //System.out.println(country);
            if (exportAmount.length()>amountLength){
                System.out.println(country);
            }
        
        }
    }
    
    public void tester(){
        //String country = "Nauru";
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //System.out.println(countryInfo(parser, country)); 
        //parser = fr.getCSVParser();
        //listExportersTwoProducts(parser, "cotton", "flowers");
        //parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");
        //parser = fr.getCSVParser();
        //System.out.println(numberOfExporters(parser, "cocoa"));
        
    }
}