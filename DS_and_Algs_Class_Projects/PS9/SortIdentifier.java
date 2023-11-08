import java.lang.Math;
import java.util.Arrays;

public class SortIdentifier{
      public static void main (String[] args){
            MysterySorts s = new MysterySorts();


           Integer[] array = {3,9,5,2,3,4};
           buildArray();

           System.out.println("Unsorted: " + Arrays.toString(array));

            //s.shuffleArray(array);
            s.sort(1,array);

            System.out.println("Sorted: " + Arrays.toString(array));

      }

      public static Integer[] buildArray(){
            //randomizing length
            int len = (int)(Math.random()*10) + 1; 
            
            /*
            constant for testing purposes
            Place len inside of [] to randomize length of array
            */
            Integer[] array = new Integer[5];

            for(int i = 0; i < array.length; i++){
                  int num = (int)(Math.random()*10) + 1;
                  array[i] = num;
            }
            return array;
      }
}