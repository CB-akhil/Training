import java.io.*;
import java.util.*;
class FileExample{
    public static void main(String[] args) {
        try{
            Scanner scan = new Scanner(new File("./input.txt"));
            PrintStream out = new PrintStream(new FileOutputStream(args[0]+".locations"));
            int lineNumber=0,previousOccured=-1,index;
            boolean flag=false;
            while(scan.hasNext()){
                String line=scan.nextLine();
                lineNumber++;
                flag=false;
                while((index=line.indexOf(args[0],previousOccured+1)) != -1 ){
                    if(!flag){
                        flag=true;
                        System.out.print(lineNumber+" ");
                        out.print(lineNumber+" ");
                    }
                    System.out.print(index + " ");
                    out.print(index + " ");
                    previousOccured=index;
                }
                System.out.println();
                out.println();
            }
            scan.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}