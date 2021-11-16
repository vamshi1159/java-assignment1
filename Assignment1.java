package Assignment1;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class Assignment1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try {
            File f=new File("C:\\Users\\abcde\\Desktop") ;
            
            String pattern=sc.next();
            while(pattern.length()!=0) {   //takes inputs repeatedly
                SearchForPattern(f, Pattern.compile(pattern));  
                sc.nextLine();
                pattern=sc.next();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public static void SearchForPattern(File f,Pattern m){

            for(File file:f.listFiles()) {
            
                if(file.isDirectory())			//if the file is a directory search through the directory for matching files
                {
                    SearchForPattern(file,m);
                }
                else if(m.matcher(file.getName()).matches())   //checks for pattern matching
                {
                    System.out.println(file.getAbsolutePath());   
                }
            }

    }
}
