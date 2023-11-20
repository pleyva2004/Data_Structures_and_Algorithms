
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.PriorityQueue;

/*
 * Implementations of various sorting algorithms.
 */

public class MysterySorts {

  
   <E extends Comparable<E>> void sort(int i, E[] A) {
    switch(i) {
      case 0:
        //System.out.println("selection");
        selectsort(A);
	break;
      case 1:
        //System.out.println("insertion");
        inssort(A);
	break;
      case 2:
        //System.out.println("heap");
        heapsort(A);
	break;
      case 3:
        //System.out.println("quick");
        quicksort(A);
	break;
      default:
	System.exit(7);
	break;
    }
  }

  
   <E extends Comparable<E>> void sort5(E[] A) {
    E[] temp = A.clone();
    mergesort(A, temp, 0, A.length-1);
  }

   <E extends Comparable<E>> void selectsort(E[] A) {
    //System.out.println("selectsort");
    for (int i = 0; i < A.length - 1; i++) { // Select i'th record
      int lowindex = i; // Remember its index
      for (int j = A.length - 1; j > i; j--)
        // Find the least value
        if (A[j].compareTo(A[lowindex]) < 0)
          lowindex = j; // Put it in place
      swap(A, i, lowindex);
    }
  }

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

   <E extends Comparable<E>> void qsort(E[] A, int i, int j) { // Quicksort
    //System.out.println("qsort");
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

   <E extends Comparable<? super E>> int findpivot(E[] A, int i, int j) {
    // return (i + j) / 2;
    return j;
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
    //System.out.println("inssort");
    for (int i = 1; i < A.length; i++)
      // Insert i'th record
      for (int j = i; (j > 0) && (A[j].compareTo(A[j - 1]) < 0); j--)
        swap(A, j, j - 1);
  }
  
 
   <E extends Comparable<E>> void heapsort(E[] A) {
    // The heap constructor invokes the buildheap method
    
    //System.out.println("heapsort");
    
   // MaxHeap<E> H = new MaxHeap<E>(A);
    PriorityQueue<E> pq = new PriorityQueue<E>(A.length);
    for (int i = 0; i < A.length; i++)
      pq.add(A[i]);
    for (int i = 0; i < A.length; i++)
      // Now sort
      A[A.length - i - 1] = pq.poll(); // Removemax places max at end
    // of heap
  }

  private static <E extends Comparable<E>> void swap(E[] A, int i, int j) {
    E temp = A[j];
    A[j] = A[i];
    A[i] = temp;
  }

  public static <E extends Comparable<E>> void shuffleArray(E[] ar) {
    Random rnd = new Random();
    for (int i = ar.length - 1; i > 0; i--) {
      int index = rnd.nextInt(i + 1);
      // Simple swap
      E a = ar[index];
      ar[index] = ar[i];
      ar[i] = a;
    }
  }
}
