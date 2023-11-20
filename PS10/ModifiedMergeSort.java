import java.util.Arrays;

public class ModifiedMergeSort{
      public static void main(String[] args){
            Integer[] nums = {3,7,6,5,4,2,4};
            
            System.out.println(Arrays.toString(nums));
            //printArray(nums);
            
            int n = nums.length;
            int k = 3;
            int blocksize = n/k;
            Integer[] temp = new Integer[n];
            
            int start, end;
            int[] indx = new int[k];

            int i = 0;
            while(0 < k){
                  start = i;
                  indx[k-1] = start;
                  if(k == 1)
                        end = n;
                  else
                        end = i + blocksize;
                        mergesort(nums,temp, start, end-1);
                        

                  i += blocksize;
                  k--;

            }
            
            System.out.println(Arrays.toString(indx));
            
            //mergesort(nums,temp, 0, n-1);

           System.out.println(Arrays.toString(nums));
            


      }

    public static <E extends  Comparable<E>> void mergesort(E[] A, E[] temp, int l, int r) {
           
      
      
            int mid = (l + r) / 2; // Select midpoint
            if (l == r)
            return; // List has one element
            mergesort(A, temp, l, mid); // sort first half
            mergesort(A, temp, mid + 1, r); // sort second half
            
            
            
            
            
            
            
            
            
            
            for (int i = l; i <= r; i++)
            // Copy subarray to temp
            temp[i] = A[i];

            int i1 = l;
            int i2 = mid + 1;
            for (int curr = l; curr <= r; curr++) {
            if (i1 == mid + 1) // Left sublist exhausted
                  A[curr] = temp[i2++];
            else if (i2 > r) // Right sublist exhausted
                  A[curr] = temp[i1++];
            else if (temp[i1].compareTo(temp[i2]) < 0)//Get small
                  A[curr] = temp[i1++];   
            else
                  A[curr] = temp[i2++];
            }
    }

  
       
}





