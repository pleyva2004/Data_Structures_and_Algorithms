import java.util.Scanner;

class Palindrome{

	static String newStr = "";

	public static void main(String[] args){
		Scanner robo = new Scanner(System.in);
		String myStr = robo.nextLine();
		System.out.println(palindromeTest(myStr));
		
	}

	static boolean palindromeTest(String str){
		int len = str.length();
	
		return(reverse(str, len).equals(str));
			
	}
	
	static String reverse(String str, int len){
	
		
		if (len == 0)
			return newStr;
		else
			newStr += str.charAt(len-1);
			return reverse(str, len-1);
	
	}


}