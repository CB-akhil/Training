import java.io.*;
import java.util.*;
import java.util.Scanner;
class DicProg{
	static Map<String,Integer>  table = new HashMap<>();

	static String getExtension(String filename){
		int startIndex=filename.lastIndexOf('.');
		return filename.substring(startIndex,filename.length());
	}

	static void add(String extension){
		if(table.containsKey(extension)){
			int val=table.get(extension);
			val++;
			table.put(extension,val);
		}else{
			table.put(extension,1);
		}
	}

	public static void scanAndAdd(File dir) {
		try{
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					//System.out.println("directory:" + file.getCanonicalPath());
					scanAndAdd(file);
				} else {
					DicProg.add(getExtension(file.getName()));
				}
			}	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void printTable(){
		Iterator it = table.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());
			it.remove(); // avoids a ConcurrentModificationException
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new  Scanner(System.in);
		String input;
		System.out.println("Enter the path of directory");
		input=scanner.next();
		File directory = new File(input);
		scanner.close();
		DicProg.scanAndAdd(directory);
		DicProg.printTable();
	}
}