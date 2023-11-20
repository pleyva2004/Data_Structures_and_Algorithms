import java.lang.Math;
import java.util.Arrays;

public class SortIdentifier{
      public static void main (String[] args){
            MysterySorts s = new MysterySorts();

           long start, now, elapsed;
           Integer[] array = buildArray();
           
           
           
           for(int i = 0; i < 3; i++){
                 System.out.println("Unsorted: " + Arrays.toString(array));
                 start = System.currentTimeMillis();
                  s.quicksort(array);
                  now = System.currentTimeMillis();
                  elapsed = now - start;
                  
                  System.out.println("Sorted: " + Arrays.toString(array));
                  System.out.println("Insertion Sort time: " + elapsed + "\n");
                  s.shuffleArray(array);
            }

        

      //       Integer[] array1 = buildArray();

      //     //  System.out.println("Unsorted: " + Arrays.toString(array1));

      //       start = System.currentTimeMillis();
      //       s.sort(0,array1);
      //       now = System.currentTimeMillis();
      //       elapsed = now - start;
            
      //     //  System.out.println("Sorted: " + Arrays.toString(array1));
      //       System.out.println("Selection Sort time: " + elapsed);
            

      }

      public static Integer[] buildArray(){
            //randomizing length
            int len = 10000; 
            
            /*
            constant for testing purposes
            Place len inside of [] to randomize length of array
            */
            Integer[] array = new Integer[len];

            for(int i = 0; i < 10000; i++){
                  array[i] = len;
                  len--;
            }
            return array;
      }
}