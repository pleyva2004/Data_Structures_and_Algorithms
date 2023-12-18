import java.util.ArrayDeque;
import java.util.Scanner;

public class Jugs {

     /*
     This program solves the the Two Jugs of Water Pouring Puzzle Using Array Deques
     */

	public static void main(String[] args){
	
		Scanner robo = new Scanner(System.in);
	
	
		int C1 = robo.nextInt();
		int C2 = robo.nextInt();
		int C3 = robo.nextInt();
		int d = robo.nextInt();

		robo.close();
	

		System.out.println(pour(C1,C1,0,C2,0,C3,d));
		
	}



    public static String pour(int c1, int C1, int c2, int C2, int c3, int C3, int d) {

		ArrayDeque <State> checked = new ArrayDeque <State> ();
      	ArrayDeque <State> visited = new ArrayDeque <State> ();

      	
		checked.add(new State(c1, c2, c3, null)); // using deque as queue
   
		int [] max = {C1, C2, C3};

      	while (!checked.isEmpty()) {


            	State current = checked.poll(); // dequeue
			visited.add(current);


            	if (current.c1 == d || current.c2 == d || current.c3 == d) { // Achieved goal!

                		StringBuilder results = new StringBuilder();
                		State s = current;


                		while(s != null){
		
					results.insert(0, s.c1 + " " + s.c2 + " " + s.c3 + "\n");
					s = s.prev;
				}

				return results.toString();
            	}


            	// generate all possible next states;
      		for (int i = 0; i <= 2; i++){
	
            		for (int m = 0; m <= 2; m++) {
                    
					int[] jugs = {current.c1, current.c2, current.c3};

					if(i != m){
						if(jugs[i] > 0){
							if(jugs[m] < max[m]) {
								int temp = Math.min(max[m] - jugs[m], jugs[i]); 
								jugs[i] -= temp;
								jugs[m] += temp;	
								
								State next = new State(jugs[0], jugs[1], jugs[2], current);	
		
								boolean flag = false;
								for(State s: visited) {
									if(s.equiv(next)) {
										 flag = true;
									}
								}
								if(!flag) {
									checked.add(next);
									visited.add(current);
								}
							}
						}
					}
      			}
			}        
    		}
		return "";
	}
}



