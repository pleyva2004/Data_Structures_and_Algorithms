import java.util.*;
import java.io.*;

public class Distance {
    public static void main(String[] args) {        
        ArrayList<Integer> from = new ArrayList<>();
        ArrayList<Integer> to = new ArrayList<>();
        
        File file = new File("../resource/asnlib/publicdata/web.txt");
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextInt()) {
                int src = scan.nextInt();
                int dst = scan.nextInt();

                from.add(src);
                to.add(dst);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
               
        System.out.println("Lengths: " + from.size() + " " + to.size());
    }
}