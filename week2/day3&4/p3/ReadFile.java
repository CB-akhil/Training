import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.*;

import javafx.util.Pair;
class ReadFile{
    private static SortedMap<String,Integer> table= new TreeMap<String,Integer>();
    public static void main(String[] args) {
        try{
            Scanner scan = new Scanner(new File("./input.txt"));
            while(scan.hasNext()){
                String word=scan.next();
                int val= (table.containsKey(word))?table.get(word):0;
                val++;
                table.put(word, val);
            }
            scan.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        table.forEach((k,v)->System.out.println(k +"  " + v));
        try{
            PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
            System.setOut(out);
            table.forEach((k,v)->System.out.println(k +"  " + v));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}