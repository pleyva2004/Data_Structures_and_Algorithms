
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.PriorityQueue;
import java.util.Collections;

/*
 * Implementations of various sorting algorithms we have covered.
 * Also selection (randomized and deterministic).
 */

public class Sorts2 {
    static Random rnd = new Random();

    <E extends Comparable<E>> void selectsort(E[] A) {
        for (int i = 0; i < A.length - 1; i++) { // Select i'th record
            int lowindex = i; // Remember its index
            for (int j = A.length - 1; j > i; j--)
                // Find the least value
                if (A[j].compareTo(A[lowindex]) < 0)
                    lowindex = j; // Put it in place
            swap(A, i, lowindex);
        }
    }

    /* Hybrid quicksort; halts recursion when array is small.
     */
    <E extends Comparable<E>> void hqsort(E[] A, int i, int j) { // Quicksort
        if (j - i < 10)
            return;
        int pivotindex = findpivot(A, i, j); // Pick a pivot
        swap(A, pivotindex, j); // Stick pivot at end
        // k will be the first position in the right subarray
        int k = partition(A, i - 1, j, A[j]);
        swap(A, k, j); // Put pivot in place
        if ((k - i) > 1)
            qsort(A, i, k - 1); // Sort left partition
        if ((j - k) > 1)
            qsort(A, k + 1, j); // Sort right partition
    }

    <E extends Comparable<E>> void quicksort(E[] A) { // Quicksort
        qsort(A, 0, A.length - 1);
    }

      <E extends Comparable<E>> void editedQuicksort(E[] A) { // Edited Quicksort
        editedQsort(A, 0, A.length - 1);
    }



    <E extends Comparable<E>> void qsort(E[] A, int i, int j) { // Quicksort
        int pivotindex = findpivot(A, i, j); // Pick a pivot
        swap(A, pivotindex, j); // Stick pivot at end
        // k will be the first position in the right subarray
        int k = partition(A, i - 1, j, A[j]);
        swap(A, k, j); // Put pivot in place
        if ((k - i) > 1)
            qsort(A, i, k - 1); // Sort left partition
        if ((j - k) > 1)
            qsort(A, k + 1, j); // Sort right partition
    }

    <E extends Comparable<E>> void editedQsort(E[] A, int i, int j) { // Edited Quicksort
        int pivotindex = goodPivot(A, i, j); // Pick a pivot
        swap(A, pivotindex, j); // Stick pivot at end
        // k will be the first position in the right subarray
        int k = partition(A, i - 1, j, A[j]);
        swap(A, k, j); // Put pivot in place
        if ((k - i) > 1)
            qsort(A, i, k - 1); // Sort left partition
        if ((j - k) > 1)
            qsort(A, k + 1, j); // Sort right partition
    }

    <E extends Comparable<E>> int findpivot(E[] A, int i, int j) {
        // return (i + j) / 2;
        return j;  // arbitrary pivot choice
    }

    <E extends Comparable<E>> int partition(E[] A, int l, int r, E pivot) {
        do { // Move bounds inward until they meet
            while (A[++l].compareTo(pivot) < 0)
                ;
            while ((r != 0) && (A[--r].compareTo(pivot) >= 0))
                ;
            swap(A, l, r); // Swap out-of-place values
        } while (l < r); // Stop when they cross
        swap(A, l, r); // Reverse last, wasted swap
        return l; // Return first position in right partition
    }

    <E extends Comparable<E>> void mergesort(E[] A, E[] temp, int l, int r) {
        int mid = (l + r) / 2; // Select midpoint
        if (l == r)
            return; // List has one element
        mergesort(A, temp, l, mid); // Mergesort first half
        mergesort(A, temp, mid + 1, r); // Mergesort second half
        for (int i = l; i <= r; i++)
            // Copy subarray to temp
            temp[i] = A[i];
        // Do the merge operation back to A
        int i1 = l;
        int i2 = mid + 1;
        for (int curr = l; curr <= r; curr++) {
            if (i1 == mid + 1) // Left sublist exhausted
                A[curr] = temp[i2++];
            else if (i2 > r) // Right sublist exhausted
                A[curr] = temp[i1++];
            else if (temp[i1].compareTo(temp[i2]) < 0) // Get smaller
                A[curr] = temp[i1++];
            else
                A[curr] = temp[i2++];
        }
    }

    <E extends Comparable<E>> void inssort(E[] A) {
        for (int i = 1; i < A.length; i++)
            // Insert i'th record
            for (int j = i; (j > 0) && (A[j].compareTo(A[j - 1]) < 0); j--)
                swap(A, j, j - 1);
    }

    <E extends Comparable<E>> void heapsort(E[] A) {
        // MaxHeap<E> H = new MaxHeap<E>(A);
        // Java PriorityQueue is min-priority by default; we reverse
        PriorityQueue<E> pq = new PriorityQueue<E>(A.length,Collections.reverseOrder());
        for (int i = 0; i < A.length; i++)
            pq.add(A[i]);
        for (int i = 0; i < A.length; i++)
            // Now sort
            A[A.length - i - 1] = pq.poll(); // Removemax (poll() in Java.)
    }

    private static <E extends Comparable<E>> void swap(E[] A, int i, int j) {
        E temp = A[j];
        A[j] = A[i];
        A[i] = temp;
    }

    public static <E extends Comparable<E>> E[] shuffleArray(E[] ar) {
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            E a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }

        return ar;
    }



    /*
    * produce a "good" pivot; that is, not too close to left of right bounds
    * follows discussion in class (notes) about deterministic select.
    */
    <E extends Comparable<E>> int goodPivot(E[] A, int l, int r) {
        int n = A.length;
        if ((r - l) < 5) {
            return getMedianPosition(A, l, r);
        }

        int count = l;
        //Divide into groups of 5
        //Sort respective subarray to retrieve its median
        for (int i = l; i <= r; i += 5) {
            int tr = i + 4;
            // check if went off r end of array
            if (tr > r) {
                tr = r;
            }
            if ((tr - i) <= 2) 
                continue;
            int babyMedian = getMedianPosition(A, i, tr);
            // As baby medians are computed, swap to front of array
            swap(A, babyMedian, count);
            count++;
        }
        return goodPivot(A, l, count);
    }


    /*
     * return the index of the median of elements of A from l to r
    */
    <E extends Comparable<E>>
    int getMedianPosition(E[] A, int l, int r) {

        // sort subarray using insertion sort (since length <= 5)
        for (int i = l; i <= r; i++) {
            int j = i;
            while (j > l && A[j-1].compareTo(A[j])>0) {
                swap(A, j, j-1);
                j -= 1;
            }
        }
        return l +  (r-l)/2;
    }


    /*
     * Randomized select as described in notes.
     * Select the qth smallest in A between indexes i and j
    */

    <E extends Comparable<E>> E select(E[] A, int i, int j, int q) {
        if (i == j)
            return A[i];
        int pivotindex = i + rnd.nextInt(j - i + 1); // Pick a random pivot
        swap(A, pivotindex, j); // Stick pivot at end

        // k will be the first position in the right subarray
        int k = partition(A, i - 1, j, A[j]);
        swap(A, k, j); // Put pivot in place

        int sz = k - i;
        if (q == sz + 1)
            return A[k];
        else if (q <= sz)
            return select(A, i, k - 1, q);
        else
            return select(A, k+1, j, q - sz-1);
    }


    <E extends Comparable<E>> E deterministicSelect(E[] A, int i, int j, int q) {
        if (i == j)
            return A[i];
        int pivotindex = goodPivot(A, i, j); // Pick a random pivot
        swap(A, pivotindex, j); // Stick pivot at end

        // k will be the first position in the right subarray
        int k = partition(A, i - 1, j, A[j]);
        swap(A, k, j); // Put pivot in place

        int sz = k - i;
        if (q == sz + 1)
            return A[k];
        else if (q <= sz)
            return select(A, i, k - 1, q);
        else
            return select(A, k+1, j, q - sz-1);
    }

}
