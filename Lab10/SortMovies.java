import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class SortMovies {

    public static void main(String[] args) {
        //File ratings = new File("Bmovies.tsv");
        File ratings = new File("C:/Coding/Repositories/Data_Structures_And_Algorithms/Lab10/movies.tsv");
        ArrayList<MovieRecord> mr = new ArrayList<MovieRecord>();

        int count = 0;

        try {
            Scanner scanr = new Scanner(ratings);
            while (scanr.hasNextLine()) {
                String line = scanr.nextLine();
                String[] tokens = line.split("\\t");
                MovieRecord mrec = new MovieRecord(tokens[0], Integer.parseInt(tokens[1]));
                mr.add(mrec);
            }
            scanr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Number of rating records= "+ mr.size());
        MovieRecord[] myArray = mr.toArray(new MovieRecord[mr.size()]);

        // add code to sort movies by rating

        // int end = 0;
        // int start = 0;
        // while (end < myArray.length-1){
        //     if(myArray[end].getTitle().charAt(0) != myArray[end + 1].getTitle().charAt(0)){

        //         qsort(myArray,start,end);
        //         start = end +1;
        //     }


        //     end++;
        // }

        int maxRating = 0;
        for(MovieRecord movie : myArray){
            if(movie.getRating() > maxRating)
                maxRating = movie.getRating();

        }

        MovieRecord[] temp = new MovieRecord[myArray.length];
        countingsort(myArray, temp, maxRating);

        
        
            
    }

    /*
     * quicksort from Sorts.java, specialized for MovieRecords
    */
    static void quicksort(MovieRecord[] A) { 
        qsort(A, 0, A.length - 1);
    }

    static void qsort(MovieRecord[] A, int i, int j) { // Quicksort
        int pivotindex = j;
        // k will be the first position in the right subarray
        int k = partition(A, i - 1, j, A[j]);
        swap(A, k, j); // Put pivot in place
        if ((k - i) > 1)
            qsort(A, i, k - 1); // Sort left partition
        if ((j - k) > 1)
            qsort(A, k + 1, j); // Sort right partition
    }


    static int partition(MovieRecord[] A, int l, int r, MovieRecord pivot) {
        do { // Move bounds inward until they meet
            while (A[++l].getRating() < pivot.getRating())
                ;
            while ((r != 0) && (A[--r].getRating() >= pivot.getRating()))
                ;
            swap(A, l, r); // Swap out-of-place values
        } while (l < r); // Stop when they cross
        swap(A, l, r); // Reverse last, wasted swap
        return l; // Return first position in right partition
    }

    static void swap(MovieRecord[] A, int i, int j) {
        MovieRecord temp = A[j];
        A[j] = A[i];
        A[i] = temp;
    }


    /*
     * counting sort from the notes, specialized for MovieRecords.
     * Assumes the ratings are between 0 and bound.
    */
    static void countingsort(MovieRecord[] A, MovieRecord[] B, int bound) { 
        int[] C = new int[bound+1];
        for(int i=0; i< bound+1;++i) C[i] = 0;
        for(int j=0; j< A.length;++j) C[A[j].getRating()]++;
        for(int i=1; i< bound+1;++i) C[i] = C[i]+C[i-1];
        for(int j=A.length-1; j>= 0;--j) {
            B[C[A[j].getRating()]-1] = A[j];
            --C[A[j].getRating()];
        }
    }
}
