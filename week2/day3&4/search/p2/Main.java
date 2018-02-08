import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.Scanner;
import static java.nio.file.StandardCopyOption.*;
import static java.nio.file.FileVisitResult.*;
class Main{
    static Path output;
    public static void scanAndMove(File dir) {
		try{
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					//System.out.println("directory:" + file.getCanonicalPath());
					scanAndMove(file);
				} else {
                    //Files.Move(file.toPath(),Paths.get(outputPath),);
                    //DicProg.add(getExtension(file.getName()));
                    checkAndMove(file);
				}
			}	
		}
		catch (Exception e) {
			e.printStackTrace();
        }
    }
    static void checkAndMove(File file){
        //System.out.println(output.toString()+"/"+file.getName());
        File f = new File(output.toString()+"/"+file.getName());
        try{
            if(f.exists() && !f.isDirectory()){
                rename(file,f);
            }else{
                Files.move(file.toPath(),Paths.get(output.toString()+"/"+file.getName()),ATOMIC_MOVE);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    static void rename(File file,File f){
        int increase=0;
        String name=file.getName();
        name = name.substring(0,name.indexOf('.'));
        String extension=file.getName().substring(file.getName().indexOf('.'));
        while(f.exists()){
            increase++;
            f = new File(output.toString()+"/"+name + increase + extension);
        } 
        try{
        Files.move(file.toPath(),Paths.get(output.toString()+"/"+name + increase + extension),ATOMIC_MOVE);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);
		String input;
		System.out.println("Enter the path of directory which  you want to Move:");
		input=scanner.next();
        File directory = new File(input);
        output=Paths.get(scanner.next());
        Main.scanAndMove(directory);
		scanner.close();
    }
}
/*class Main extends SimpleFileVisitor<Path>{
    @Override
    Public FileVisitResult vistFile(Path file,BasicFileAttributes attr){
        if(attr.isRegularFile())
            Files.move(file, target,);
    }
}*/