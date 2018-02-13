import java.io.FileReader;
import java.io.*;
import java.lang.*;
import java.util.*;
import org.apache.commons.csv.*;
import java.nio.file.*;
class RemoveCsvDuplicates{
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        try(
            Reader csvData = new FileReader("./input.csv");
            CSVParser parser = CSVParser.parse(csvData,CSVFormat.RFC4180);
            //CSVPrinter print = new CSVPrinter( ,CSVFormat.RFC4180);
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("./output.csv"));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.RFC4180);
        ){
            //CSVPrinter p = parser.print();
            Iterable<CSVRecord> csvRecords = parser.getRecords();
            int prev=0;
            for(CSVRecord csvRecord: csvRecords){
                String a="";
                for(String temp:csvRecord){
                    a+=temp+',';
                }
                System.out.println(a);
                s.add(a);
                System.out.println(s.size());
                if(s.size()>prev){
                    csvPrinter.printRecord(csvRecord);
                    prev=s.size();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}