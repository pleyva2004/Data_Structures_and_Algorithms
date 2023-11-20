import java.util.Scanner;

class RecursiveMultiply{



	public static void main(String[] args){
		
		Scanner robo = new Scanner(System.in);
        
		int a = robo.nextInt();
      
		
		int b = robo.nextInt();
	
        
		System.out.println(multi(a,b));

	}

	public static long multi(int a, int b){
		long res;
		if (a == 1)
      			return b;
		else if (a % 7 == 0){
			res = multi(a/7, b);
            		return res + res + res + res + res + res + res;
		}
		else if (a % 5 == 0){
			res = multi(a/5, b);
            		return res + res + res + res + res;
		}
		else if (a % 3 == 0){
			res = multi(a/3, b);
			return res + res + res;
		}
		else if (a % 2 == 0){
           		res = multi(a/2, b);
           		return res + res;
      		}

    		else{
      			res = multi(a-1, b);
     			return res + b;
		}
	}
}