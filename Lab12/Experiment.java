import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/* Program sorts many arrays using one of the "Mystery" sorts
 * sort4-sort4. You can plot the run times using Plot (if compatable
 * with where you are running the program) or simply print out the
 * results and plot with any plotting software.
 */

public class Experiment {

    public static Sorts2 srts;
    public static Random rnd;

    public static void main(String[] args) {

        rnd = new Random(7);
        srts = new Sorts2();

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
            B = Arrays.copyOf(A,n);
            for(int i=0; i<n; ++i) System.out.print(A[i]+" ");
            System.out.println();

            for(int i=0; i<n; ++i) System.out.print(B[i]+" ");
            System.out.println();

            A_startTime = System.nanoTime();
            //int q = srts.select(A,0,A.length-1, n/2);
            srts.quicksort(A);
            A_avgTime += System.nanoTime()-A_startTime;
            
            B_startTime = System.nanoTime();
            srts.editedQuicksort(B);
           // int y = srts.deterministicSelect(B,0,A.length-1, n/2);

            B_avgTime += System.nanoTime()-B_startTime;


            
            System.out.println("The "+(n/2)+" smallest value is "+q);
            System.out.println("The "+(n/2)+" smallest value is "+y);
            //srts.heapsort(A);
            for(int i=0; i<n; ++i) System.out.print(A[i]+" ");
            System.out.println();

            for(int i=0; i<n; ++i) System.out.print(B[i]+" ");
            System.out.println();
        }
        System.out.println("Average time: "+ A_avgTime);
        System.out.println("Average time: "+ B_avgTime);
        
    }


}


