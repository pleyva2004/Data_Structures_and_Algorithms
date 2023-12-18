import java.io.*;
import java.util.*;

public class Quantiles {

    static Random rnd = new Random();
    public static void main(String[] args){
        File incomes = new File("C:\\Coding\\Repositories\\Data_Structures_and_Algorithms\\PS11\\Incomes.txt");

        ArrayList<Integer> incomeList = new ArrayList<>();


        //Read file
        try {
			Scanner scanner = new Scanner(incomes);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				
                //Add elements in file to list 
                incomeList.add(Integer.parseInt(line));

			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

        Scanner robo = new Scanner(System.in);
        int k = robo.nextInt();
        double n = incomeList.size();
        int m = (int)Math.ceil(n/k); //Length of each Quartile
        robo.close();

        //Turn arraylist into array
        Integer[] incomeArr = new Integer[incomeList.size()];
        incomeList.toArray(incomeArr);

         for(int j = 1; j < k; j++){
            int num = select(incomeArr, 0, incomeArr.length-1, j*m);
            System.out.println(num);
         }
        

    }

    static Integer select(Integer[] A, int i, int j, int q) {
//System.out.println(Arrays.toString(A));
        if(A[j] == q){
            return A[j];
            
        }
        if (i == j){
            System.out.println(A[j]);
                return A[i];
        }
            
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


    static int partition(Integer[] A, int l, int r, Integer pivot) {
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

    private static <E extends Comparable<E>> void swap(E[] A, int i, int j) {
        E temp = A[j];
        A[j] = A[i];
        A[i] = temp;
    }
}