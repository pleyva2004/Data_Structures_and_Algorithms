import java.util.ArrayList;
import java.text.NumberFormat;

/* Program sorts many arrays using one of the "Mystery" sorts
 * sort4-sort4. You can plot the run times using Plot (if compatable
 * with where you are running the program) or simply print out the
 * results and plot with any plotting software.
 */

public class Experiment {

  public static void main(String[] args) {
    MysterySorts srts = new MysterySorts();
    int n;
    int REP = 10; // how many times to repeat experiment
    int[] wcompl = new int[4]; // worst-case complexity; for each sort, 0=linear or nlgn, 1=quadratic
    int[] acompl = new int[4]; // average-case complexity; for each sort, 0=linear or nlgn, 1=quadratic
    long start, now, elapsed;
    Integer[] A;

      int n0 = 10000;

    for(int s=0;s<4;++s){ // try sort(s,.)
      System.out.println("Testing sort "+ s);
      n =  n0;
      A = new Integer[n];

      // first try already sorted
      start = System.currentTimeMillis();
      for (int rep = 0; rep < REP; ++rep) {
        //srts.shuffleArray(A);
        for (int j = 0; j < n; ++j) A[j] = j;
        srts.sort(s,A);
      }
      now = System.currentTimeMillis();
      elapsed = now - start;
      System.out.println("Sorted short array time: "+elapsed);

      // now do longer arrays
      n =  2*n0;
      A = new Integer[n];

      start = System.currentTimeMillis();
      for (int rep = 0; rep < REP; ++rep) {
        //srts.shuffleArray(A);
        for (int j = 0; j < n; ++j) A[j] = j;
        srts.sort(s,A);
      }
      now = System.currentTimeMillis();
      elapsed = now - start;
      System.out.println("Sorted long array time: "+elapsed);

      // now shuffled
      n =  n0;
      A = new Integer[n];

      start = System.currentTimeMillis();
      for (int rep = 0; rep < REP; ++rep) {
        for (int j = 0; j < n; ++j) A[j] = j;
        srts.shuffleArray(A);
        srts.sort(s,A);
      }
      now = System.currentTimeMillis();
      elapsed = now - start;
      System.out.println("Shuffled short array time: "+elapsed);

      // now do longer arrays
      n =  2*n0;
      A = new Integer[n];

      start = System.currentTimeMillis();
      for (int rep = 0; rep < REP; ++rep) {
        for (int j = 0; j < n; ++j) A[j] = j;
        srts.shuffleArray(A);
        srts.sort(s,A);
      }
      now = System.currentTimeMillis();
      elapsed = now - start;
      System.out.println("Shuffled long array time: "+elapsed);

    }
  }
}
