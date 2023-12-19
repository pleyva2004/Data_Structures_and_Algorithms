import java.util.Arrays;


public class Experiments {
      public static void main(String[] argws){
            Sorts2 srts = new Sorts2();

            int n = 10;
            Integer[] A = new Integer[n];
            Integer[] B = new Integer[n];
            int REPS = 1;
            double A_avgTime = 0.0;
            long A_startTime;
            double B_avgTime = 0.0;
            long B_startTime;
            long endTime;
            for(int rep=0; rep<REPS; ++rep) {
                  for(int i=0; i<A.length; ++i) A[i] = i+1;
                  A = srts.shuffleArray(A);
                  
                  B = srts.shuffleArray(Arrays.copyOf(A,n));
                  
                  System.out.println("Shuffled arrays:");
                  System.out.print("A: ");
                  for(int i=0; i<n; ++i) System.out.print(A[i]+" ");
                  System.out.println();

                  System.out.print("B: ");
                  for(int i=0; i<n; ++i) System.out.print(B[i]+" ");
                  System.out.println("\n");

                  A_startTime = System.nanoTime();
                  //int q = srts.select(A,0,A.length-1, n/2);
                  srts.quicksort(A);
                  A_avgTime += System.nanoTime()-A_startTime;
            
                  B_startTime = System.nanoTime();
                  srts.editedQuicksort(B);
                  //int y = srts.deterministicSelect(B,0,A.length-1, n/2);

                  B_avgTime += System.nanoTime()-B_startTime;


            
                  //System.out.println("The "+(n/2)+" smallest value is "+q);
                  //System.out.println("The "+(n/2)+" smallest value is "+y);
                  //srts.heapsort(A);

                  System.out.print("A: ");
                  for(int i=0; i<n; ++i) System.out.print(A[i]+" ");
                  System.out.println();

                  System.out.print("B: ");
                  for(int i=0; i<n; ++i) System.out.print(B[i]+" ");
                  System.out.println("\n");
            }
            System.out.println("'A' Average time: " + A_avgTime);
            System.out.println("'B' Average time: " + B_avgTime + "\n");
            System.out.println("A uses orgininal quikSort and selectSort");
            System.out.println("B uses edited quickSort or deterministicSelect");
      }
}
