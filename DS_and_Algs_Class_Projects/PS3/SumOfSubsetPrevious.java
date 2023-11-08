import java.util.Scanner;
import java.util.Arrays;

class SumOfSubsetPrevious {

	public static void main(String[] args){

		Scanner robo = new Scanner(System.in);

		String[] intArray = robo.nextLine().split(" ");

		int[] nums = new int[intArray.length];

		copyElements(intArray, nums);

		int totalSums = 0;
		
		for(int i = nums.length-1; i > 0; i--){
			if(sumofsubprev(nums,i, 0, 0))
			totalSums += 1;
		}
		
		System.out.println("Total number of possible sums of subets" + totalSums);
		
	}

	static void copyElements(String[] intArray, int[] nums){
	
	
		for(int i = 0; i < nums.length; i++){
			nums[i] = Integer.parseInt(intArray[i]);
		}

	}

	public static boolean sumofsubprev(int[] intArray,int n, int idx, int sum) {

		if (idx >= n)
			return false;

		if (sum == intArray[idx])
			return true;

		return sumofsubprev(intArray, n, idx+1, sum+intArray[idx]) || sumofsubprev(intArray, n, idx+1, sum);

	}	

	
}