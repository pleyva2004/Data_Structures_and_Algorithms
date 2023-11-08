import java.util.*;
import java.io.*;

public class MaxHomophones{
      static OALDictionary<String, Pronunciation> PDict = new OALDictionary<String, Pronunciation>();

      public static void main(String[] args){

            readFile();

            
            Scanner robo = new Scanner(System.in);

            int end = robo.nextInt();

                

      }

      static void readFile(){
            File file = new File("D:/Java/PS6/cmudict.0.7a.txt");

            long start = System.currentTimeMillis();

            try{
                  Scanner scanner = new Scanner(file);

                  while(scanner.hasNextLine()){

                        String str = scanner.nextLine();

                        if(str.substring(0,3).equals(";;;"))
                              continue; //skip command lines
                              
                        Pronunciation p = new Pronunciation(str);

                        PDict.insert(p.getWord(), p);
                  }

                  scanner.close();
            } catch(FileNotFoundException e) {
                  e.printStackTrace();                        
            }

            long middle = System.currentTimeMillis();

            System.out.println("Loaded dictionary; elapsed time " + (middle - start));

            int count = 0;

            for(Pronunciation p : PDict.values()){

                  ++count;

                  System.out.println(p);

                  if(count > 5)
                        break;

            }

            long end = System.currentTimeMillis();

            System.out.println("Run times: load dictionary= " + (middle - start) + " process= " + (end - middle) + " total= " + (end - start));
      }

      
}