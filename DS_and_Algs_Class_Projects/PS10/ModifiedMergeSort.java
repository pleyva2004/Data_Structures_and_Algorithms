import java.lang.Arrays;

public class ModifiedMergeSort {
      public static void main(String[] args){
            int[] nums = {3,7,6,5,4,2,1,4,3,4,5,7,9,5,7,6};

            int n = nums.length;
            int k = 4;
            int blocksize = n/k;

            int start, end;

            int i = 0;
            while(0 < k){
                  start = i;
                  if(k == 1)
                        end = n;
                  else
                        end = i + blocksize;
                  
                  i += blocksize;
                  k--;
            }


      }

}
