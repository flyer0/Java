package writer;
import java.io.*;


public class Writer {

    public static void main( String [] args) {
        try {
            BufferedWriter f = new BufferedWriter(new FileWriter("hftest.txt"));
            f.write("Tell us!");
            f.newLine();
            f.write("Alright, said Deep Thought.");
            f.newLine();
            f.close();
        }catch (IOException e){
           e.printStackTrace();
        }
    }
      
    
    
}
