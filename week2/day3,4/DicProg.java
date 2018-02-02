import java.io.*;
import java.util.Scanner;
class DicProg{

	public static void addFilesAndSubDirectoriesfiles(String directoryName, List list){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isFile()){
                System.out.println(file.getAbsolutePath());
            } else if (file.isDirectory()){
                listFilesAndFilesSubDirectories(file.getAbsolutePath());
            }
        }
    }

	public static void main(String[] args) {
		Scanner scanner = new  Scanner(System.in);
		String input;
		System.out.println("Enter the Directory to Search:");
		input=scanner.next();
		File directory = new File(input);
		File[] flist=directory.listfiles();
		List<File> list = new ArrayList<>();
		for(File file:flist){

		}
	}
}