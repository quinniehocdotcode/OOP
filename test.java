import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
class test {
  public static void main(String args[]) throws FileNotFoundException {
    File file = new File("text.txt");
    Scanner sc = new Scanner(file);  
    while(sc.hasNextLine()){
      System.out.println(sc.nextLine());
    }
}
}